package ispyt1;

public interface List {
    
    void addFirst (Object o);
    
    void addLast (Object o);
    
    void add (Object o, int index);
    
    void removeFirst ();
    
    void removeLast ();
    
    void remove (int index);
    
    void changeFirst (Object o);
    
    void changeLast (Object o);
    
    void change (Object o, int index);
    
    int size ();
    
    int index (Object value);
    
    Object get (int index);
    
    int sum();
    
    void clean();
    
}
