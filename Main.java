package project;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

    public class Main {

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            DoublyLinkedList dList = new DoublyLinkedList();
            String islem = "******************** \n"
                    + "1 - Liste Okuma \n"
                    + "2 - Öğrenci Ekleme \n"
                    + "3 - Öğrenci Bilgisi Sorgulama \n"
                    + "4 - Öğrenci Kaydı Silme \n"
                    + "5 - Kayıtları Artan Sırada Listeleme \n"
                    + "6 - Kayıtları Azalan Sırada Listeleme \n"
                    + "7 - Programdan Çıkış... \n";

            System.out.print(islem);
            //Input alma fonksiyonu çalıştırıldı
            int var = islemAl();

            while (var < 7) {
                System.out.println();
                switch (var) {
                    //Okuma İşlemi
                    case 1:

                        Scanner fileRead = null;
                        try {
                            // Dosya okuması gerçekleştiriliyor
                            fileRead = new Scanner(new FileInputStream("ogrenciler.txt"));
                        } catch (FileNotFoundException e) {
                            System.out.println("Dosya bulunamadı.");
                            System.exit(0);
                        }
                        while (fileRead.hasNext()) {

                            String str = fileRead.nextLine();
                            Student student = Student.createStudent(str);
                            dList.addStudent(student);

                        }
                        System.out.println("Liste okuma başarıyla tamamlandı...");
                        break;
                    //Klavyeden veri ekleme işlemi
                    case 2:

                        System.out.println("- Numara,İsim Soyisim,Telefon,Telefon - şeklinde giriniz!");
                        System.out.print("Eklenecek öğrencinin verilerini giriniz: ");
                        String str = scan.nextLine();
                        Student student = Student.createStudent(str);
                        if(student !=null) {
                            dList.addStudent(student);
                            System.out.println("Öğrenci ekleme başarıyla tamamlandı...");
                        }
                        break;
                    //Öğrenci bilgisi yazdırma
                    case 3:

                        System.out.println("-Sorgulanacak Öğrencinin-");
                        System.out.print("Adı soyadı:");
                        String nameSurname = scan.nextLine();
                        dList.searchName(nameSurname);
                        break;
                    //Öğrenci silme
                    case 4:
                        System.out.print("Silinecek öğrencinin numarasını giriniz :");
                        try {
                            int studentNumber = scan.nextInt();
                            scan.nextLine();
                            dList.deleteStudent(studentNumber);
                        } catch (Exception e) {
                            System.out.println("Lütfen numara giriniz!");
                        }

                        break;
                    //Artan sırada listeleme
                    case 5:
                        dList.displayIncrease();
                        break;
                    //Azalan sırada listeleme
                    case 6:
                        dList.displayDecrease();
                        break;
                    default:
                        throw new AssertionError();

                }
                var = islemAl();

            }
            System.out.println("Uygulamadan çıkış yapılıyor...");
        }

        //İnput hata kontrolü için metot oluşturuldu
        private static int islemAl() {
            Scanner scan = new Scanner(System.in);
            //Döngü için değişken oluşturuldu
            boolean ex = true;
            //Değişkene başlangıç değeri atandı
            int var = -1;
            while (ex) {
                try {
                    System.out.println("********************");
                    System.out.print("Lütfen İşlem Seçiniz: ");
                    var = scan.nextInt();
                    if (var > 0 && var < 8) {
                        ex = false;
                    }

                } catch (Exception e) {
                    System.out.println("Lütfen geçerli bir input giriniz!");
                    scan.nextLine();
                }
            }
            return var;
        }
    }

