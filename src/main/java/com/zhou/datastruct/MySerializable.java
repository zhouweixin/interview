package com.zhou.datastruct;

import java.io.*;

public class MySerializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Book book = new Book("Java入门", 1);
        FileOutputStream fos = new FileOutputStream("book.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(book);
        oos.close();
        fos.close();
        System.out.println("保存book: " + book);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.ser"));
        Book book1 = (Book)ois.readObject();
        System.out.println("读取book: " + book1);
        ois.close();
    }
}

class Book implements Serializable{
    private String name;
    private int version;

    public Book(String name, int version) {
        this.name = name;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", version=" + version +
                '}';
    }
}
