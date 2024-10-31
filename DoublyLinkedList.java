package project;

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

        
        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;

        }

        public Node addStudent(Student student) {
           

            Node newNode = new Node(student);

           
            if (this.head == null) {
               
                this.head = newNode;
                this.tail = newNode;

               
            } else if (this.head.student.getStuNumber() > newNode.student.getStuNumber()) {

                this.head.prev = newNode;
                newNode.next = this.head;
                this.head = newNode;

                if (tail.next != null) {
                    tail = tail.next;
                }

                
            } else {
                Node current = this.head;
           
                while (current.next != null && current.next.student.getStuNumber() < newNode.student.getStuNumber()) {

                    current = current.next;
                }

               
                newNode.next = current.next;
                current.next = newNode;
                newNode.prev = current;

                if (newNode.next != null) {
                    newNode.next.prev = newNode;
                }
              
                Node toTail = this.head;
                while (toTail.next != null) {

                    toTail = toTail.next;
                }
                this.tail = toTail;

            }

            return this.head;
        }

        public void searchName(String nameSurname) {
            
            Node current = this.head;
            if (this.head == null) {
                System.out.println("List is empty.");
            }
            else {
                while (current != null) {
                    if (nameSurname.equals(current.student.getNameSurname())) {
                        System.out.println(current.student.toString());

                    }
                    current = current.next;
                }

            }
        }
        public void deleteStudent(int stuNumber) {
            
            Node student = searchNumber(stuNumber);

            if (this.head == null || student == null) {
                System.out.println("Student is not found");
                return;
            }
            if (this.head == student) {
                this.head = this.head.next;
            } 
            if (this.tail == student) {
                this.tail=this.tail.prev;
            }
            if (student.next != null) {

                student.next.prev = student.prev;

            }
            if (student.prev != null) {
                student.prev.next = student.next;
            }
            System.out.println("Student is successfully deleted.);
        }
        public void displayIncrease() {
            Node current = this.head;

            if (this.head == null) {
                System.out.println("List is empty.");

            } else {
                System.out.println("DoublyLinked List ");
                while (current != null) {
                    System.out.print(current.student + " ");
                    current = current.next;

                }
            }
        }

        public void displayDecrease() {
            Node current = this.tail;
            if (this.tail == null) {
                System.out.println("List is empty.");
            }
            else {
                System.out.println("DoublyLinkedList");
                while (current !=null) {
                    System.out.println(current.student+" ");
                    current=current.prev;
                }
            }
        }


        private Node searchNumber(int stuNumber) {
            Node current = this.head;
            if (this.head == null) {
                System.out.println("List is empty.");
            } else {
                while (current != null) {
                    if (current.student.getStuNumber() == stuNumber) {
                        return current;
                    }
                    current = current.next;
                }
            }
            return null;
        }
    }

