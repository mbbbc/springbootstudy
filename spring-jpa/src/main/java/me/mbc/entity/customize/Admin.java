package me.mbc.entity.customize;import lombok.AllArgsConstructor;import lombok.Data;import lombok.NoArgsConstructor;import lombok.experimental.Accessors;import org.hibernate.annotations.CreationTimestamp;import org.hibernate.annotations.UpdateTimestamp;import org.springframework.format.annotation.DateTimeFormat;import javax.persistence.*;import java.util.Date;@Entity@Table(name = "sys_admin")@Data@Accessors(chain = true)@AllArgsConstructor@NoArgsConstructorpublic class Admin {    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)    private Long id;    private String name;    @Column(name="birth_date")    //@DateTimeFormat(pattern = "yyyy-MM-dd")    @Temporal(TemporalType.DATE)    private Date birthDate;    @Column(name="create_date")    @CreationTimestamp    @Temporal(TemporalType.TIMESTAMP)    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")    private Date createDate;    @Column(name="update_date")    @UpdateTimestamp    @Temporal(TemporalType.TIMESTAMP)    private Date updateDate;}