package persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "getAirportNameByCityName",query = "select airport.name from Airport airport inner join airport.city city where city.name= :name"),
        @NamedQuery(name = "deleteAirportByName",query = "delete from Airport where name= :name"),
        @NamedQuery(name = "changeAirportName",query = "update from Airport set name= :newName where name= :name"),
        @NamedQuery(name = "countAirportName",query = "select count(name) from Airport where name= :name"),
        @NamedQuery(name = "findAirportByName",query = "select airport from Airport airport where name= :name"),
        @NamedQuery(name = "findAirportsInCity",query = "select airport from Airport airport inner join airport.city city where city.name= :cityName")

})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "airports")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cities_id")
    private City city;



}
