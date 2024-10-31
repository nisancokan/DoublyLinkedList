package project;


//Inner Node class tanımlanıyor.
    class Node {

        public Student student;
        public Node next;
        public Node prev;

        public Node(Student student) {
            this.student = student;
            this.next = null;
            this.prev = null;
        }
    }

    public class DoublyLinkedList {

        private Node head;
        private Node tail;

        //Constructor oluşturuluyor.
        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;

        }

        public Node addStudent(Student student) {
            //Eklenecek olan node nesnesi oluşturuluyor.

            Node newNode = new Node(student);

            //Eğer liste boş işe
            if (this.head == null) {
                //Head ve tail değişkenlerine atama yapılıyor.
                this.head = newNode;
                this.tail = newNode;

                //Yeni eklenen node nesnesinin değeri head den daha küçük ise
            } else if (this.head.student.getStuNumber() > newNode.student.getStuNumber()) {

                this.head.prev = newNode;
                newNode.next = this.head;
                this.head = newNode;

                if (tail.next != null) {
                    tail = tail.next;
                }

                //Yeni eklenen node nesnesinin değeri daha büyük ise
            } else {
                Node current = this.head;
                //Karşılaştırma döngüsü
                while (current.next != null && current.next.student.getStuNumber() < newNode.student.getStuNumber()) {

                    current = current.next;
                }

                //Araya eklenen nesnenin next ve prev 'i ayarlanıyor.
                newNode.next = current.next;
                current.next = newNode;
                newNode.prev = current;

                if (newNode.next != null) {
                    newNode.next.prev = newNode;
                }
                //Tail ataması yapılmadıysa
                Node toTail = this.head;
                while (toTail.next != null) {

                    toTail = toTail.next;
                }
                this.tail = toTail;

            }

            return this.head;
        }

        public void searchName(String nameSurname) {
            //Linkedlistte arama yapmak için başından
            Node current = this.head;
            if (this.head == null) {
                System.out.println("Liste boş.");
            }
            else {
                while (current != null) {
                    //Öğrenci ismi listede aranıyor
                    if (nameSurname.equals(current.student.getNameSurname())) {
                        System.out.println(current.student.toString());

                    }
                    current = current.next;
                }

            }
        }
        public void deleteStudent(int stuNumber) {
            //Başka metot kullanılıyor
            Node student = searchNumber(stuNumber);

            //Liste boş ise veya öğrenci listede yok ise
            if (this.head == null || student == null) {
                System.out.println("Öğrenci listede bulunamadı.");
                return;
            }

            // Eğer head kısmında ise
            if (this.head == student) {
                this.head = this.head.next;
            } // Eğer head kısmında değil ise
            if (this.tail == student) {
                this.tail=this.tail.prev;
            }
            if (student.next != null) {

                student.next.prev = student.prev;

            }
            if (student.prev != null) {
                student.prev.next = student.next;
            }
            System.out.println("Öğrenci silme işlemi başarılı");
        }
        public void displayIncrease() {
            //Linkedlist in başından başlamak için nesne oluşturuluyor
            Node current = this.head;

            if (this.head == null) {
                System.out.println("Liste boş.");

            } else {
                System.out.println("DoublyLinked List ");
                while (current != null) {
                    //Öğrenci bilgileri yazdırılıyor
                    System.out.print(current.student + " ");
                    current = current.next;

                }
            }
        }

        public void displayDecrease() {
            //Linkedlist in sonundan başlamak için nesne oluşturuluyor
            Node current = this.tail;
            if (this.tail == null) {
                System.out.println("Liste boş");
            }
            else {
                System.out.println("DoublyLinkedList");
                while (current !=null) {
                    //Öğrenci bilgileri yazdırılıyor
                    System.out.println(current.student+" ");
                    current=current.prev;
                }
            }
        }


        //Silme komutu için numaraya göre Student nesnesini bulan method
        private Node searchNumber(int stuNumber) {
            Node current = this.head;
            if (this.head == null) {
                System.out.println("Liste boş.");
            } else {
                while (current != null) {
                    //Öğrenci numarası listede aranıyor
                    if (current.student.getStuNumber() == stuNumber) {
                        return current;
                    }
                    current = current.next;
                }
            }
            return null;
        }
    }

