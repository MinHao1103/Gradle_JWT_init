package com.hao.Gradle_JWT_Init.utils.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.hao.Gradle_JWT_Init.exception.JwtCreationException;
import com.hao.Gradle_JWT_Init.exception.JwtInitializationException;
import com.hao.Gradle_JWT_Init.exception.JwtVerificationException;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMDecryptorProvider;
import org.bouncycastle.openssl.PEMEncryptedKeyPair;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.bouncycastle.openssl.jcajce.JcePEMDecryptorProviderBuilder;

import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.security.KeyPair;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class JwtUtil {
    static RSAPublicKey rsaPublicKey;
    static RSAPrivateKey rsaPrivateKey;

    /**
     * 靜態初始化塊，確保 BouncyCastleProvider 只添加一次
     */
    static {
        if (Security.getProvider("BC") == null) {
            Security.addProvider(new BouncyCastleProvider());
        }
    }

    /**
     * 初始化 RSA 公鑰和私鑰
     *
     * @param crt        X.509 憑證的 PEM 格式
     * @param privateKey RSA 私鑰的 PEM 格式
     * @throws JwtInitializationException
     */
    public static void init(String crt, String privateKey) {
        try {
            CertificateFactory cf = CertificateFactory.getInstance("X.509", "BC");
            Certificate crtObj = cf.generateCertificate(new ByteArrayInputStream(crt.getBytes()));
            rsaPublicKey = (RSAPublicKey) crtObj.getPublicKey();
        } catch (Exception e) {
            throw new JwtInitializationException("Failed to initialize RSA public key", e);
        }

        if (privateKey != null) {
            try {
                PEMParser pemParser = new PEMParser(new StringReader(privateKey));
                Object object = pemParser.readObject();
                PEMDecryptorProvider decProv = new JcePEMDecryptorProviderBuilder().build("".toCharArray());
                JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider("BC");

                if (object instanceof PEMEncryptedKeyPair) {
                    System.out.println("Encrypted key - we will use provided password");
                    KeyPair kp = converter.getKeyPair(((PEMEncryptedKeyPair) object).decryptKeyPair(decProv));
                    rsaPrivateKey = (RSAPrivateKey) kp.getPrivate();
                } else if (object instanceof PrivateKeyInfo) {
                    rsaPrivateKey = (RSAPrivateKey) converter.getPrivateKey((PrivateKeyInfo) object);
                } else {
                    KeyPair kp = converter.getKeyPair((PEMKeyPair) object);
                    rsaPrivateKey = (RSAPrivateKey) kp.getPrivate();
                }
            } catch (Exception e) {
                throw new JwtInitializationException("Failed to initialize RSA private key", e);
            }
        }
    }

    /**
     * 使用指定的資料創建 JWT Token。
     *
     * @param data 資料
     * @return 字符串形式的 JWT
     * @throws JwtCreationException
     */
    public static String createToken(JwtData data) {
        try {
            Algorithm algorithm = Algorithm.RSA256(rsaPublicKey, rsaPrivateKey);
            return JWT.create()
                    .withIssuer(data.getId().toString())
                    .withClaim("email", data.getEmail())
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new JwtCreationException("Failed to create JWT", e);
        }
    }

    /**
     * 驗證 JWT 的有效性並取得資訊
     *
     * @param token 要驗證的 JWT Token
     * @return 解碼的 JWT 資料
     * @throws JwtVerificationException
     */
    public static JwtData verifyToken(final String token) {
        try {
            Algorithm algorithm = Algorithm.RSA256(rsaPublicKey, rsaPrivateKey);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);

            JwtData data = new JwtData();
            data.setId(Long.valueOf(jwt.getIssuer()));
            data.setEmail(jwt.getClaim("email").asString());
            return data;
        } catch (Exception e) {
            throw new JwtVerificationException("Failed to verify JWT", e);
        }
    }

}
