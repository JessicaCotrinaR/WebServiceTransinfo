package models;

import com.avaje.ebean.*;

/**
 * Created by jessicacotrina on 4/4/17.
 */
public class PersonExtendInformationModel extends Model {

    public int personaFK;
    public String categoryPerson;
    public String typePerson;
    public String row;
    public String seat;
    public String otherLocation;
    public String restraintSystem;
    public String airbagsActivation;
    public String expulsion;
    public String speedRelated;
    public String extraction;
    public String distractedBy;
    public String driverCirncunstanceBC;
    public String conditionCollisionTime;
    public String safetyEquipmentUsed;
    public String suspectAlcoholUse;
    public String testStatusAl;
    public String testTypeAl;
    public String testResultAl;
    public String testResultTP;
    public String suscpectControlledSubstances;
    public String distractedDriberBY;
    public String testStatusSub;
    public String testTypeSub;
    public String testResultSub;
    public String actionsBeforeCollision;
    public String inWayToSchool;
    public String actionsAtCollisionTime;
    public String locationWhenCollision;
    public String transportedByME;
    public String transportedTo;
    public String transportedBy;
    public String medicalEmergenciesNumber;
    public int idPersonExtendInformation;

    public int ambulanceCSPNumber;

    public PersonExtendInformationModel() {
    }
    public long addPersonExtendInformationModel(PersonExtendInformationModel personExtendInformationModel){
        long result;

        String sql = "INSERT INTO PersonExtendInformation (PersonaFK, CategoryPerson, TypePerson, Row, Seat, OtherLocation," +
                "RestraintSystem, AirbagsActivation, Expulsion, SpeedRelated, Extraction,  DriverCirncunstanceBC, DistractedDriverBy, DistractedBy, ConditionCollisionTime, " +
                "SafetyEquipmentUsed, SuspectAlcoholUse, TestStatusAl, TestTypeAl, TestResultAl, TestResultTP, SuscpectControlledSubstances," +
                " TestStatusSub, TestTypeSub, TestResultSub, ActionsBeforeCollision, InWayToSchool, ActionsAtCollisionTime, " +
                " LocationWhenCollision, TransportedByME, TransportedTo, TransportedBy, MedicalEmergenciesNumber, AmbulanceCSPNumber ) " +

                "VALUES (:PersonaFK, :CategoryPerson, :TypePerson, :Row, :Seat, :OtherLocation," +
                ":RestraintSystem, :AirbagsActivation, :Expulsion, :SpeedRelated, :Extraction,  :DriverCirncunstanceBC, :DistractedDriverBy, :DistractedBy, :ConditionCollisionTime, " +
                ":SafetyEquipmentUsed, :SuspectAlcoholUse, :TestStatusAl, :TestTypeAl, :TestResultAl, :TestResultTP, :SuscpectControlledSubstances," +
                " :TestStatusSub, :TestTypeSub, :TestResultSub, :ActionsBeforeCollision, :InWayToSchool, :ActionsAtCollisionTime, " +
                " :LocationWhenCollision, :TransportedByME, :TransportedTo, :TransportedBy, :MedicalEmergenciesNumber, :AmbulanceCSPNumber )";


        SqlUpdate insert = Ebean.createSqlUpdate(sql);
        insert.setParameter("PersonaFK",  personExtendInformationModel.personaFK);
        insert.setParameter("CategoryPerson", personExtendInformationModel.categoryPerson);
        insert.setParameter("TypePerson", personExtendInformationModel.typePerson);
        insert.setParameter("Row", personExtendInformationModel.row);
        insert.setParameter("Seat", personExtendInformationModel.seat);
        insert.setParameter("OtherLocation", personExtendInformationModel.otherLocation);
        insert.setParameter("RestraintSystem", personExtendInformationModel.restraintSystem);
        insert.setParameter("AirbagsActivation", personExtendInformationModel.airbagsActivation);
        insert.setParameter("Expulsion", personExtendInformationModel.expulsion);
        insert.setParameter("SpeedRelated", personExtendInformationModel.speedRelated);
        insert.setParameter("Extraction", personExtendInformationModel.extraction);
        insert.setParameter("DriverCirncunstanceBC", personExtendInformationModel.driverCirncunstanceBC);
        insert.setParameter("DistractedDriverBy", personExtendInformationModel.distractedDriberBY);
        insert.setParameter("DistractedBy", personExtendInformationModel.distractedBy);
        insert.setParameter("ConditionCollisionTime", personExtendInformationModel.conditionCollisionTime);
        insert.setParameter("SafetyEquipmentUsed", personExtendInformationModel.safetyEquipmentUsed);
        insert.setParameter("SuspectAlcoholUse", personExtendInformationModel.suspectAlcoholUse);
        insert.setParameter("TestStatusAl", personExtendInformationModel.testStatusAl);
        insert.setParameter("TestTypeAl", personExtendInformationModel.testTypeAl);
        insert.setParameter("TestResultAl", personExtendInformationModel.testResultAl);
        insert.setParameter("TestResultTP", personExtendInformationModel.testResultTP);
        insert.setParameter("SuscpectControlledSubstances", personExtendInformationModel.suscpectControlledSubstances);
        insert.setParameter("TestStatusSub", personExtendInformationModel.testStatusSub);
        insert.setParameter("TestTypeSub", personExtendInformationModel.testTypeSub);
        insert.setParameter("TestResultSub", personExtendInformationModel.testResultSub);
        insert.setParameter("ActionsBeforeCollision", personExtendInformationModel.actionsBeforeCollision);
        insert.setParameter("InWayToSchool", personExtendInformationModel.inWayToSchool);
        insert.setParameter("ActionsAtCollisionTime", personExtendInformationModel.actionsAtCollisionTime);
        insert.setParameter("LocationWhenCollision", personExtendInformationModel.locationWhenCollision);
        insert.setParameter("TransportedByME", personExtendInformationModel.transportedByME);
        insert.setParameter("TransportedTo", personExtendInformationModel.transportedTo);
        insert.setParameter("TransportedBy", personExtendInformationModel.transportedBy);
        insert.setParameter("MedicalEmergenciesNumber", personExtendInformationModel.medicalEmergenciesNumber);
        insert.setParameter("AmbulanceCSPNumber", personExtendInformationModel.ambulanceCSPNumber);

        System.out.println("Update: " + insert.getSql());
        Transaction tx = Ebean.beginTransaction();
        boolean success= true;

        try {
            result = insert.execute();
            String sqlgetId = "SELECT @@IDENTITY as theId";
            SqlRow id = Ebean.createSqlQuery(sqlgetId)
                    .findUnique();
            result = id.getLong("theId");
            System.out.println("Resulting Id: " + result);


        }catch (Exception e){
            System.out.println(e.getMessage());
            result = 0;
            success= false;
        }
        finally {
            if(success){
                tx.commit();
            }
            else {
                tx.rollback();
            }
        }
        return result;
    }

    public int updatePersonExtendInformationModel(PersonExtendInformationModel personExtendInformationModel) {
        int result;
        String sql = "UPDATE PersonExtendInformation SET PersonaFK = :PersonaFK, CategoryPerson = :CategoryPerson, TypePerson = :TypePerson, Row = :Row, Seat = :Seat, OtherLocation = :OtherLocation," +
                "RestraintSystem = :RestraintSystem, AirbagsActivation = :AirbagsActivation, Expulsion = :Expulsion, SpeedRelated = :SpeedRelated, Extraction = :Extraction,  DriverCirncunstanceBC = :DriverCirncunstanceBC, DistractedDriverBy = :DistractedDriverBy, DistractedBy = :DistractedBy, ConditionCollisionTime = :ConditionCollisionTime," +
                "SafetyEquipmentUsed = :SafetyEquipmentUsed, SuspectAlcoholUse = :SuspectAlcoholUse, TestStatusAl = :TestStatusAl, TestTypeAl = :TestTypeAl, TestResultAl = :TestResultAl, TestResultTP = :TestResultTP, SuscpectControlledSubstances = :SuscpectControlledSubstances," +
                " TestStatusSub = :TestStatusSub, TestTypeSub = :TestTypeSub, TestResultSub = :TestResultSub, ActionsBeforeCollision = :ActionsBeforeCollision, InWayToSchool = :InWayToSchool, ActionsAtCollisionTime = :ActionsAtCollisionTime," +
                " LocationWhenCollision = :LocationWhenCollision, TransportedByME = :TransportedByME, TransportedTo = :TransportedTo, TransportedBy = :TransportedBy, MedicalEmergenciesNumber = :MedicalEmergenciesNumber, AmbulanceCSPNumber = :AmbulanceCSPNumber" +
                "WHERE idPersonExtendInformation = :idPersonExtendInformation";
        SqlUpdate update = Ebean.createSqlUpdate(sql);

        update.setParameter("PersonaFK",  personExtendInformationModel.personaFK);
        update.setParameter("CategoryPerson", personExtendInformationModel.categoryPerson);
        update.setParameter("TypePerson", personExtendInformationModel.typePerson);
        update.setParameter("Row", personExtendInformationModel.row);
        update.setParameter("Seat", personExtendInformationModel.seat);
        update.setParameter("OtherLocation", personExtendInformationModel.otherLocation);
        update.setParameter("RestraintSystem", personExtendInformationModel.restraintSystem);
        update.setParameter("AirbagsActivation", personExtendInformationModel.airbagsActivation);
        update.setParameter("Expulsion", personExtendInformationModel.expulsion);
        update.setParameter("SpeedRelated", personExtendInformationModel.speedRelated);
        update.setParameter("Extraction", personExtendInformationModel.extraction);
        update.setParameter("DriverCirncunstanceBC", personExtendInformationModel.driverCirncunstanceBC);
        update.setParameter("DistractedDriverBy", personExtendInformationModel.distractedDriberBY);
        update.setParameter("DistractedBy", personExtendInformationModel.distractedBy);
        update.setParameter("ConditionCollisionTime", personExtendInformationModel.conditionCollisionTime);
        update.setParameter("SafetyEquipmentUsed", personExtendInformationModel.safetyEquipmentUsed);
        update.setParameter("SuspectAlcoholUse", personExtendInformationModel.suspectAlcoholUse);
        update.setParameter("TestStatusAl", personExtendInformationModel.testStatusAl);
        update.setParameter("TestTypeAl", personExtendInformationModel.testTypeAl);
        update.setParameter("TestResultAl", personExtendInformationModel.testResultAl);
        update.setParameter("TestResultTP", personExtendInformationModel.testResultTP);
        update.setParameter("SuscpectControlledSubstances", personExtendInformationModel.suscpectControlledSubstances);
        update.setParameter("TestStatusSub", personExtendInformationModel.testStatusSub);
        update.setParameter("TestTypeSub", personExtendInformationModel.testTypeSub);
        update.setParameter("TestResultSub", personExtendInformationModel.testResultSub);
        update.setParameter("ActionsBeforeCollision", personExtendInformationModel.actionsBeforeCollision);
        update.setParameter("InWayToSchool", personExtendInformationModel.inWayToSchool);
        update.setParameter("ActionsAtCollisionTime", personExtendInformationModel.actionsAtCollisionTime);
        update.setParameter("LocationWhenCollision", personExtendInformationModel.locationWhenCollision);
        update.setParameter("TransportedByME", personExtendInformationModel.transportedByME);
        update.setParameter("TransportedTo", personExtendInformationModel.transportedTo);
        update.setParameter("TransportedBy", personExtendInformationModel.transportedBy);
        update.setParameter("MedicalEmergenciesNumber", personExtendInformationModel.medicalEmergenciesNumber);
        update.setParameter("AmbulanceCSPNumber", personExtendInformationModel.ambulanceCSPNumber);
        update.setParameter("idPersonExtendInformation", personExtendInformationModel.idPersonExtendInformation);


        try {
            update.execute();
            result = idPersonExtendInformation;
        }catch (Exception e){
            System.out.println(e.getMessage());
            result = 0;
        }
        return result;
    }



}
