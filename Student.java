
    package project;

import java.util.ArrayList;

    public class Student {

        private int stuNumber;
        private ArrayList<String> numberList;
        private String nameSurname;

        public Student() {

        }

        public Student(String nameSurname, int stuNumber, ArrayList<String> numberList) {
            this.stuNumber = stuNumber;
            this.nameSurname = nameSurname;
            this.numberList = numberList;
        }

        public Student(Student student) {
            this.stuNumber = student.getStuNumber();
            this.nameSurname = student.getNameSurname();
            this.numberList = student.getNumberList();
        }

        public int getStuNumber() {
            return this.stuNumber;
        }

        public void setStuNumber(int stuNumber) {
            this.stuNumber = stuNumber;
        }

        public ArrayList<String> getNumberList() {
            return this.numberList;
        }

        public void setNumberList(ArrayList<String> numberList) {
            this.numberList = numberList;
        }

        public String getNameSurname() {
            return this.nameSurname;
        }

        public void setNameSurname(String nameSurname) {
            this.nameSurname = nameSurname;
        }

        @Override
        public String toString() {

            return String.format("-Öğrencinin- \n "
                            + "Adı Soyadı : %s \n "
                            + "Okul Numarası : %s \n "
                            + "Telefon Numarası/Numaraları : %s \n",
                    this.getNameSurname(), this.getStuNumber(), this.getNumberList());
        }

        public static Student createStudent(String str) {
            //Virgüllere göre satır ayrılarak listeye atılıyor
            String[] Items = str.split(",");

            //Boşluklar siliniyor
            Items = str.split("\\s*,\\s*");

            //Telefon numaraları için liste oluşturuluyor
            ArrayList<String> numberList = new ArrayList<>();
            String name = null;
            int stuNumber = 0;
            String phoneNumber;

            //Liste üzerinde dönülerek kişi eklemek için adımlar yapılıyor
            for (int i = 0; i < Items.length; i++) {

                switch (i) {
                    case 0:
                        try {
                            stuNumber = Integer.valueOf(Items[i]);
                        } catch (Exception e) {
                            System.out.println("Lütfen geçerli aralıkta "
                                    + "öğrenci numarası giriniz.");
                            return null;
                        }
                        break;
                    case 1:
                        name = Items[i];
                        break;
                    default:
                        phoneNumber = Items[i];
                        numberList.add(phoneNumber);
                        break;
                }
            }
            //Student nesnesi oluşturuluyor
            Student student = new Student(name, stuNumber, numberList);
            return student;
        }
    }

