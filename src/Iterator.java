interface Iterator {
    boolean hasNext();
    Object next();
}
class NameRepository {
    public String names[] = {"John", "Jane", "Alice", "Bob"};
    public Iterator getIterator() {
        return new NameIterator();
    }
    private class NameIterator implements Iterator {
        int index;

        public boolean hasNext() {
            return index < names.length;
        }

        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}