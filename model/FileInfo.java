package cs.tu.studentSprint1.Model;

public class FileInfo {
    private String name;
    private String size;
    public FileInfo(){
    }
    public FileInfo(String name,String size){
        setName(name);
        setSize(size);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
