package otobot.v4;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import static java.awt.event.KeyEvent.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class OtobotV4 {
    
    static void ctrlV(Clipboard clipboard, Robot robotum, String str) {
        
        StringSelection selection = new StringSelection(str);
        clipboard.setContents(selection, null);
        
        robotum.keyPress(VK_CONTROL);
        robotum.keyPress(VK_V);
        robotum.keyRelease(VK_V);
        robotum.keyRelease(VK_CONTROL);
        robotum.keyPress(VK_ENTER);
        robotum.keyRelease(VK_ENTER);
    }
    
    public static void main(String args[]) {
        
        System.out.println("otobot v4");
        
        try { 
            
            Robot robotum = new Robot();
            File spamtxt = new File("spam.txt");
            Scanner okuyan = new Scanner(spamtxt);
            Scanner kullan = new Scanner(System.in);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            
            System.out.print("HerHer tarafından kodlanmıştır ~\n\nKullanım Klavuzu:\n-\"spam.txt\" isimli text dosyasının içine sırasıyla gönderilmesini istediğiniz mesajları satır satır yazınız.\n-Gönderilen mesajların arasında olmasını istediğiniz süreyi dakika cinsinden yazın. Dakikadan kısa bir süre beklemesini istiyorsanız küsürat ile de yazabilirsiniz.\n-Süre girildikten 5 saniye sonra program çalışmaya başlayacaktır. Bu 5 saniye içinde mesajların yazılacağı kutucuğa sanki mesaj yazacakmış gibi bir kere tıklamanız gerekmektedir.\n-bu gada\n\nMesajlar arasında kaç dakika beklensin?: ");
            int cooldown = (int)(kullan.nextFloat() * 60 * 1000);
            
            
            System.out.print("Programın başlamasına kalan saniye:  ");
            for(int i = 5; i >= 0; i--) {
                
                System.out.print("\b" + i);
                Thread.sleep(1000);
            }
            
            
            while(true) {
                
                if(!okuyan.hasNext()) {
                    
                    okuyan.close();
                    okuyan = new Scanner(spamtxt);
                    continue;
                }
                
                String str = okuyan.nextLine();
                ctrlV(clipboard, robotum, str);
                System.out.println("\n\nMesaj gönderildi: " + str + "\n");
                
                
                for(int i = cooldown/1000; i >= 0; i--) {
                    
                    if(i % 60 < 10) {
                        
                        System.out.print("\rMesajın gönderilmesine kalan süre: " + i / 60 + ":0" + i % 60);
                    }
                    else {
                        
                        System.out.print("\rMesajın gönderilmesine kalan süre: " + i / 60 + ":" + i % 60);
                    }
                    Thread.sleep(1000);
                }
            }
        }
        catch (java.awt.AWTException e) {
            
            System.out.println("Uyarı: Hata Kodu 1\n(Kapatıp açmayı deneyin.)");
        }
        catch (InterruptedException e) {
            
            System.out.println("Uyarı: Hata Kodu 2\n(Kapatıp açmayı deneyin.)");
        }
        catch (FileNotFoundException e) {
            
            System.out.println("Uyarı: Hata Kodu 3 - spam.txt bulunamadı!\n(Klasöre \"spam\" isminde bir .txt dosyası eklemelisiniz.)");
        }
        catch (InputMismatchException e) {
            
            System.out.println("Uyarı: Hata Kodu 4 - hatalı sayı girdiniz.\n(Rakamları öğrenin.)");
        }
    }
}

    /*static int[] char2keyCode(char[] chars) {
        
        int[] keyCode = new int[chars.length];
        
        for (int i = 0; i < keyCode.length; i++) {
            
            keyCode[i] = java.awt.event.KeyEvent.getExtendedKeyCodeForChar(chars[i]);
            System.out.println(keyCode[i]);
        }
        
        return keyCode;
    }*/
    
    /*static char[] str2charArray(String str) {
        
        char[] chars = new char[str.length()]; 
        
        for (int i = 0; i < chars.length; i++) {
            
            chars[i] = str.charAt(i);
        }
        
        return chars;
    }*/