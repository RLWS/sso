package rsa.test;

import com.rlws.sso.commons.dto.BaseResult;
import org.junit.Test;

import java.security.*;
import java.util.ArrayList;
import java.util.Date;

public class RsaGetKeyPair {

    //private KeyPairGenerator keyPairGenerator = null;

    @Test
    public void getKyePair(){
        String b = "asdf";
        try {
            KeyPairGenerator rsa = KeyPairGenerator.getInstance("RSA");
            rsa.initialize(1024);
            KeyPair keyPair = rsa.genKeyPair();
            PrivateKey aPrivate = keyPair.getPrivate();
            PublicKey aPublic = keyPair.getPublic();
            byte[] aPrEncoded = aPrivate.getEncoded();
            System.out.println("aPr:");
            for (byte c:aPrEncoded){
                System.out.print(c);
            }
            System.out.println();
            byte[] aPuEncoded = aPublic.getEncoded();
            System.out.println("aPu:");
            for (byte c:aPuEncoded){
                System.out.print(c);
            }
            //System.out.println(keyPair.getPublic().getEncoded());
            //System.out.println("124874683418293204718079695709185254385818510357218397644543393026694782734501896209418305949740641798443219532899329691532970964633557270424572669512350700623831137290333189692722025297954760637873688772933521499216606597781080034901879755891874178906756915105130784214402179104258155710259974290618298779867".length());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Tese() throws InterruptedException {
        ArrayList<byte[]> list = new ArrayList<>();
        boolean b = true;
        int i = 0;
        while (b){
            i++;
            list.add(new byte[1024<<8]);
            System.out.println(i);
            Thread.sleep(100);
        }
    }

}
