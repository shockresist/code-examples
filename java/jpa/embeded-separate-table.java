
@Entity
@Table(name = "ASANIMZA_CONTAINER")
@SecondaryTable(name="USER_CUSTOMER_CODE",
        pkJoinColumns=@PrimaryKeyJoinColumn(name="ENTITY_ID"))  //поле в таблице 2. внешний ключ на первичный ключ таблицы 1
class EntityOne{

    @Id
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="type", column=@Column(name ="OTYPE", table="USER_CUSTOMER_CODE")),
            @AttributeOverride(name="code", column=@Column(name ="CODE", table="USER_CUSTOMER_CODE")),
            @AttributeOverride(name="customerId", column=@Column(name="CUSTOMER_ID", table="USER_CUSTOMER_CODE")),
    })
    @NotNull
    private CustomerCode customerCode;

}

@Embeddable
public class CustomerCode {

    @Column(name="CODE")
    private String code;

    @Column(name="CUSTOMER_ID")
    private Long customerId;

    @Column(name="OTYPE")
    private String type;

}