import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Country implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private long annualEmissions;
    private double annualEmissionsPerCapita;

    public Country() {}

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public long getAnnualEmissions() {return annualEmissions;}
    public void setAnnualEmissions(long annual_emissions) {this.annualEmissions = annual_emissions;}

    public double getAnnualEmissionsPerCapita() {return annualEmissionsPerCapita;}
    public void setAnnualEmissionsPerCapita(double annual_emissions_per_capita) {this.annualEmissionsPerCapita = annual_emissions_per_capita;}
}
