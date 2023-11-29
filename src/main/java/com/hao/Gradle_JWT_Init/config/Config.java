package com.hao.Gradle_JWT_Init.config;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Config {

    /**
     * JWT
     **/
    public static String CRT = "-----BEGIN CERTIFICATE-----\n" +
            "MIIDETCCAfkCFGH6GrWei+SaWZmWglK6PpwAl5zRMA0GCSqGSIb3DQEBCwUAMEUx\n" +
            "CzAJBgNVBAYTAlRXMQ4wDAYDVQQIDAVTdGF0ZTEVMBMGA1UECgwMT3JnYW5pemF0\n" +
            "aW9uMQ8wDQYDVQQDDAZDb21tb24wHhcNMjMxMTI5MDYyMzM5WhcNMjQxMTI4MDYy\n" +
            "MzM5WjBFMQswCQYDVQQGEwJUVzEOMAwGA1UECAwFU3RhdGUxFTATBgNVBAoMDE9y\n" +
            "Z2FuaXphdGlvbjEPMA0GA1UEAwwGQ29tbW9uMIIBIjANBgkqhkiG9w0BAQEFAAOC\n" +
            "AQ8AMIIBCgKCAQEAyXuiwFoycRTnfsXgTzs4T1KN/2Pdvvz5Cmc3LUmJuUGBHTyE\n" +
            "g8T6phDWQa/wDON9uscp+oZFF2zqDwngP1UTPGFnmRKBZL276htCemG8h0KGx37c\n" +
            "2gQriVH2ipe9IEgCFugkkP5LBz+XNprEf/xZo4crtyQXkEWqRy8d+Gq5Wyqt0s++\n" +
            "+c1IjdRUKIqa4zrT9uMl4ulXtaoDcROmZmgc1SzF7XQpmFKGIkhVqoPyoO6WHxMD\n" +
            "2Zm2oBpx94AVZGSUyzvfoyv6py+XPKtC4YRO48J6YaSRb95ab0dnaGpWeguiqHCU\n" +
            "kLSoyrDGXoCGQiTO0PzYJvmt6Q5HWO1gjtgj5QIDAQABMA0GCSqGSIb3DQEBCwUA\n" +
            "A4IBAQCG1wv/qDYM0HKRgtH8Q/LubZY1Q2R+LiOCFW31E42Wh+ji0u1gIGBPlIKa\n" +
            "lj6M1mIrNw///EEAW3AE/PGx2RXsDReXRJavGKxyinceXTKxj5GSboxDuhWI3cIm\n" +
            "M+H91SnGU44bQ47lqmSGpoaoYU/gtYYr898JNh9nFxzYPy2jWg6V0sWfxS/E+FuH\n" +
            "xki3vLVs1I6kS1fLbF6J0veKl3L7xgcTHLRBqq9OXhNBuVTqiApJ6/e461o6cXWN\n" +
            "RN1EoUObwiNDkX8EPr8uPMeyNe8GfZ/TffO3Ebu9Gw9L1B+CiEKZghq6+13DVch6\n" +
            "nb0/mA/W1/K/vJGtNo2F8GOD16wG\n" +
            "-----END CERTIFICATE-----\n";
    public static String KEY = "-----BEGIN PRIVATE KEY-----\n" +
            "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDJe6LAWjJxFOd+\n" +
            "xeBPOzhPUo3/Y92+/PkKZzctSYm5QYEdPISDxPqmENZBr/AM4326xyn6hkUXbOoP\n" +
            "CeA/VRM8YWeZEoFkvbvqG0J6YbyHQobHftzaBCuJUfaKl70gSAIW6CSQ/ksHP5c2\n" +
            "msR//Fmjhyu3JBeQRapHLx34arlbKq3Sz775zUiN1FQoiprjOtP24yXi6Ve1qgNx\n" +
            "E6ZmaBzVLMXtdCmYUoYiSFWqg/Kg7pYfEwPZmbagGnH3gBVkZJTLO9+jK/qnL5c8\n" +
            "q0LhhE7jwnphpJFv3lpvR2doalZ6C6KocJSQtKjKsMZegIZCJM7Q/Ngm+a3pDkdY\n" +
            "7WCO2CPlAgMBAAECggEALCNmmwbnZ/hxYkdNBW5uvonSS7GAAXf/wrSr1ML4Zdog\n" +
            "w9vfF9LOKhUkKs21I82uXH2HB7fkaOZWPCcothcYGLEp9dGlAQHDqdyA6riAiY0c\n" +
            "Y5W6IhSpyPJotSHar7i2pHgEkrLyksrugGrVQ0hwBq/09rD0bImmbOO4iBQxOPQz\n" +
            "o83OV+ooj70RshivRZkhPnYSXEGzcfnLRB9D0PKlBxnJkrwi5goTasSLF5tz8gfi\n" +
            "84nzgEcuqVVy0IrhoX177Gx9dH/QPTmpSfOLu512WejEfev6YrYuRffs7QGCIT//\n" +
            "jDjqEn+k0B04bztMwl4N29nBtLuNSSqV72PQPflHPQKBgQD5E0U96LP0QykY9s1Y\n" +
            "GvgQ7jvFSqX00prsIpOYE+dx9lCs7sfRHpgFu+zoRv3eSzhenztNI3T8AB90QOG5\n" +
            "XWYBz8Yj8DQtw1jkxRcPxEEwIXAyoYG2vzAx/UCzpnlk22zi6mSsHMc6kjgqlPeB\n" +
            "kkEBqv86CsWXymFSjKGWQd+DOwKBgQDPFaObjQP+r9AiOlhLiEIRuroDkIFxjMCl\n" +
            "5x/SsQjTWfx8Df7I81GX8IfLGx69IepolKKl22p8K+YE5kAsROtl/wlbwCPrQWrq\n" +
            "0e6AaK8WbOQPP+MVxRYzyIVbmiuWb6IRtSiOpgCFoxUMVB9nwx1x7TSrfhdXq/P+\n" +
            "REkWI8pDXwKBgEPuP4o89yd9Ua4fUa3f3Rww/Vg3nb+B2QLiA0MM2qi4NxSTIygj\n" +
            "oe6ebGSFSCPifANChlfpfbRlDC8Wqvl1Qabo1e9jSbfZeVsbbci9C9JmrEUCy2/e\n" +
            "APUBTy4wDxe0yKOyrbZLOwL8chka+83454Xe7zETUwStC5IKDOAAI0eVAoGBALLN\n" +
            "Ekiah1p+Xw1OpzIAYluAiF/Pg5SRXT1hxB5c8SvbxJ8wTk8fl9HCwtzhe7b987F8\n" +
            "tLrUKqswFBki3UHb+AxHGsN3sQvNng1GWdHRkWuhdYCdPutrEnJ/rnWbNgtcM+lq\n" +
            "K6yPNGAuoVvVvpAO7fuSPincYzc1pyRhvWE6YcetAoGAYk70LcQpDLPtm6LmPUtS\n" +
            "LZeeJFIhrzTKQQ6T8qrkz92NWAxFDZZIF5cZHi8mqnoGAxXzNzisEdg7rtBXe8s7\n" +
            "O6nHK2rf60qX6ATkezhfXjvndbpUHnRyzFiFTbKQ4/8ieK+0l9DdlWQVhZNLwfXM\n" +
            "GctYYc16EmPb7YkhflqwXew=\n" +
            "-----END PRIVATE KEY-----\n";

}
