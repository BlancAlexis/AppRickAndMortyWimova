package fr.alexis.apprickandmorty;

public class Info {
    int count;
    int pages;
    String next;
    String prev;


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
    public void setPrev(String prev) {
        this.prev = prev;
    }

    public String getPrev() {
        return prev;
    }
}
