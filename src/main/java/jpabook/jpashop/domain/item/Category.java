package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue
    @Column(name="category_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name="category_item",
            joinColumns = @JoinColumn(name="category_id"),
            inverseJoinColumns = @JoinColumn(name="item_id"))
    private List<Item> items = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)//자식은 여럿이고 부모는 하나
    @JoinColumn(name="parent_id") //상위 카테고리의 아이디를 가져오는것
    private Category parent;

    @OneToMany(mappedBy = "parent")
    //부모는 하나고 자식은 여럿,하위카테고리에서 상위카테고리의 아이디를 가져오기때문에
    //mappedBy 당한것
    private List<Category> child = new ArrayList<>();
    //==연관관계 메서드==//
    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
    }
}
