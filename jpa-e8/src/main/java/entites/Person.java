package entites;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Person")
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    /*
        @JoinTable only works with relationships
        in @CollectionTable @JoinColumn indicates the foreign key
     */
    @ElementCollection
    @CollectionTable(name = "phone", joinColumns = @JoinColumn(name = "person"))
    @Column(name = "number")
    private List<String> phoneNumbers;

    @ElementCollection
    @CollectionTable(name = "document", joinColumns = @JoinColumn(name = "person"))
    private List<Document> documents;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}
