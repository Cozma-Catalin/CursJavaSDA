package persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;


@NamedQueries({
        @NamedQuery(name = "showPurchasedTripsByUser",query = "select p from PurchasedTrip p inner join p.user user where name= :name"),
        @NamedQuery(name = "showPurchasedTripsByDate",query = "select p from PurchasedTrip p where (dateOfPurchase between :dateOfPurchase and :currentDate) ")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "purchased_trips")
public class PurchasedTrip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "trips_id")
    private Trip trip;

    @Column(name = "date_of_purchase")
    private Date dateOfPurchase;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "discount")
    private double discount;



}
