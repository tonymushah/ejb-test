package mg.tonymushah.ejbtest.server.classes.inputs;

import java.io.Serializable;

import jakarta.persistence.TypedQuery;

public class Pagination implements Serializable {
    private int offset;
    private int limit;
    public Pagination(int offset, int limit) {
        this.setOffset(offset);
        this.setLimit(limit);
    }
    public int getOffset() {
        return offset;
    }
    public void setOffset(int offset) {
        this.offset = offset;
    }
    public int getLimit() {
        return limit;
    }
    public void setLimit(int limit) {
        this.limit = limit;
    }
    public Pagination() {
        this(0, 10);
    }
    public <T> TypedQuery<T> set(TypedQuery<T> query){
        query.setFirstResult(this.offset);
        query.setMaxResults(this.limit);
        return query;
    }
}
