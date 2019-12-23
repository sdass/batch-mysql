package com.subra.batchmysql;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by sdass on 12/19/2019.
 */
@Entity
@Table(name="bets_promo")
public class BetsPromo implements Serializable {
    private static final long serialVersionUID = 1169915472955649915L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //pk

    @NotNull
    private String email;

    @NotNull
    @Column(name="first_name")
    private String firstName;

    @NotNull
    @Column(name="last_name")
    private String lastName;

    @Column(name="bets_id")
    private Long betsId;

    private String state;

    @Column(name="promo_id")
    private Long promoId;

    @Column(name="signup_date")
    private LocalDateTime signupDate;

    public LocalDateTime getSignupDate() {
        return signupDate;
    }

    public void setSignupDate(LocalDateTime signupDate) {
        this.signupDate = signupDate;
    }

    public BetsPromo(){

    }


    public BetsPromo(String email, String firstName, String lastName,
                     Long betsId, String state, Long promoId) {
        super();
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.betsId = betsId;
        this.state = state;
        this.promoId = promoId;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Long getBetsId() {
        return betsId;
    }
    public void setBetsId(Long betsId) {
        this.betsId = betsId;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public Long getPromoId() {
        return promoId;
    }
    public void setPromoId(Long promoId) {
        this.promoId = promoId;
    }

    @Override
    public String toString() {
        return "BetsPromo [id=" + id + ", email=" + email + ", firstName="
                + firstName + ", lastName=" + lastName + ", betsId=" + betsId
                + ", state=" + state + ", promoId=" + promoId + "]";
    }



}
