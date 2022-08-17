package lesson07;

class SimpleBox<T extends Number> {
    private T obj;

    public SimpleBox(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public String getType() {
        return obj.getClass().getSimpleName();
    }

}