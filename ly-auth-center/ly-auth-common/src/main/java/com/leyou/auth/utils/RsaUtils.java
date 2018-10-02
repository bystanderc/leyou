package com.leyou.auth.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author bystander
 * @date 2018/9/30
 */
public class RsaUtils {

    /**
     * 从文件中读取公钥
     *
     * @param fileName
     * @return
     * @throws Exception
     */
    public static PublicKey getPublicKey(String fileName) throws Exception {
        byte[] bytes = readFile(fileName);
        return getPublicKey(bytes);
    }

    /**
     * 从文件中读取私钥
     * @param fileName
     * @return
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(String fileName) throws Exception{
        byte[] bytes = readFile(fileName);
        return getPrivateKey(bytes);
    }

    /**
     * 获取公钥
     *
     * @param bytes
     * @return
     * @throws Exception
     */
    public static PublicKey getPublicKey(byte[] bytes) throws Exception {
        X509EncodedKeySpec spec = new X509EncodedKeySpec(bytes);
        KeyFactory factory = KeyFactory.getInstance("RSA");
        return factory.generatePublic(spec);
    }

    /**
     * 生成私钥
     *
     * @param bytes
     * @return
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(byte[] bytes) throws Exception {
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(bytes);
        KeyFactory factory = KeyFactory.getInstance("RSA");
        return factory.generatePrivate(spec);
    }

    /**
     * 读取文件
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    public static byte[] readFile(String fileName) throws IOException {
        return Files.readAllBytes(new File(fileName).toPath());

    }

    /**
     * 根据密文，生存rsa公钥和私钥,并写入指定文件
     *
     * @param publicKeyFilename  公钥文件路径
     * @param privateKeyFilename 私钥文件路径
     * @param secret             生成密钥的密文
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    public static void generateKey(String publicKeyFilename, String privateKeyFilename, String secret) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        SecureRandom secureRandom = new SecureRandom(secret.getBytes());
        keyPairGenerator.initialize(1024, secureRandom);
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        // 获取公钥并写出
        byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
        writeFile(publicKeyFilename, publicKeyBytes);
        // 获取私钥并写出
        byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
        writeFile(privateKeyFilename, privateKeyBytes);
    }

    /**
     * 向目标路径写入文件
     *
     * @param destPath
     * @param bytes
     * @throws IOException
     */
    public static void writeFile(String destPath, byte[] bytes) throws IOException {
        File dest = new File(destPath);
        if (!dest.exists()) {
            dest.createNewFile();
        }
        Files.write(dest.toPath(), bytes);
    }
}
