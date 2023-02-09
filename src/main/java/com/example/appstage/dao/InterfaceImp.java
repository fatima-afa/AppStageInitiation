package com.example.appstage.dao;

import com.example.appstage.services.SignletonConnexionDB;
import com.example.appstage.modeles.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


public class InterfaceImp implements Interface {
        public ArrayList<stagiaire> getAllStagiaires() {
            Connection conn= SignletonConnexionDB.getConnection();
            ArrayList<stagiaire> stagiaires=new ArrayList<>();
            try {
                PreparedStatement pstm=conn.prepareStatement("select * from stagiaire");
                ResultSet rs= pstm.executeQuery();
                while (rs.next()){
                    stagiaire e=new stagiaire(rs.getString("cni"),rs.getString("nom"),rs.getString("prenom"),rs.getString("etablissement"),rs.getString("specialite"),getEncadrantByIdEncadrant(rs.getInt("idEncadrant")),getServiceByIdService(rs.getInt("idService")),getDemandeurByIdDemandeur(rs.getInt("idDemandeur")));
                    stagiaires.add(e);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return stagiaires;
        }

        public String getEncadrantByIdEncadrant(int idEncadrant){

            Connection conn = SignletonConnexionDB.getConnection();

            try {
                PreparedStatement pstm = conn.prepareStatement("select * from encadrant where idEncadrant = ? ");
                pstm.setInt(1, idEncadrant);
                ResultSet rs = pstm.executeQuery();
                rs.next();
                encadrant e  = new encadrant(idEncadrant, rs.getString("nom"), rs.getString("fonction"),rs.getString("division"));
                return e.getNom();
            } catch (Exception var5) {
                var5.printStackTrace();
                return null;
            }

        }
        public int getIdEncadrantByEncadrant(String nomEncadrant){

            Connection conn = SignletonConnexionDB.getConnection();

            try {
                PreparedStatement pstm = conn.prepareStatement("select idEncadrant from encadrant where nom = ? ");
                pstm.setString(1, nomEncadrant);
                ResultSet rs = pstm.executeQuery();
                rs.next();
                return rs.getInt("idEncadrant");
                //encadrant e  = new encadrant(rs.getInt("idEncadrant"), nomEncadrant, rs.getString("fonction"),rs.getString("division"),rs.getString("unite"),rs.getString("tele"));
               // return e.getIdEncadrant();
            } catch (Exception var5) {
                var5.printStackTrace();
                return -1;
            }

        }

        public int getIdDossierByDossier(String photo){

            Connection conn = SignletonConnexionDB.getConnection();

            try {
                PreparedStatement pstm = conn.prepareStatement("select * from dossier where photo = ? ");
                pstm.setString(1, photo);
                ResultSet rs = pstm.executeQuery();
                rs.next();
                dossier e  = new dossier(rs.getInt("idEncadrant"), photo);
                return e.getIdDossier();
            } catch (Exception var5) {
                var5.printStackTrace();
                return -1;
            }

        }


        public int getIdServiceByService(String nomService){

            Connection conn = SignletonConnexionDB.getConnection();

            try {
                PreparedStatement pstm = conn.prepareStatement("select * from service where intitule = ? ");
                pstm.setString(1, nomService);
                ResultSet rs = pstm.executeQuery();
                rs.next();
                service e  = new service(rs.getInt("idService"), nomService);
                return e.getIdService();
            } catch (Exception var5) {
                var5.printStackTrace();
                return -1;
            }

        }

        public int getIdDemandeurByDemandeur(String nomDemandeur){

            Connection conn = SignletonConnexionDB.getConnection();

            try {
                PreparedStatement pstm = conn.prepareStatement("select * from demandeur where nom = ? ");
                pstm.setString(1, nomDemandeur);
                ResultSet rs = pstm.executeQuery();
                rs.next();
                demandeur e  = new demandeur(rs.getInt("idDemandeur"), nomDemandeur);
                return e.getIdDemandeur();
            } catch (Exception var5) {
                var5.printStackTrace();
                return -1;
            }

        }


        public String getServiceByIdService(int idService)
        {
            Connection conn = SignletonConnexionDB.getConnection();

            try {
                PreparedStatement pstm = conn.prepareStatement("select * from service where idService = ? ");
                pstm.setInt(1, idService);
                ResultSet rs = pstm.executeQuery();
                rs.next();
                service s  = new service(idService, rs.getString("intitule"));
                return s.getIntitule();
            } catch (Exception var5) {
                var5.printStackTrace();
                return null;
            }
        }
        public String getDemandeurByIdDemandeur(int idDemandeur){
            Connection conn = SignletonConnexionDB.getConnection();

            try {
                PreparedStatement pstm = conn.prepareStatement("select * from demandeur where idDemandeur = ? ");
                pstm.setInt(1, idDemandeur);
                ResultSet rs = pstm.executeQuery();
                rs.next();
                demandeur d  = new demandeur(idDemandeur, rs.getString("nom"));
                return d.getNom();
            } catch (Exception var5) {
                var5.printStackTrace();
                return null;
            }

        }

        public ArrayList<TreeClass> getAllStagiairesByService(String serv){
            Connection conn = SignletonConnexionDB.getConnection();
            ArrayList<TreeClass> stagiaires = new ArrayList();

            try {
                PreparedStatement pstm=conn.prepareStatement("select * from stagiaire s,stage st, effectuer ef where ef.idStage = st.idStage and ef.idStagiaire = s.idStagiaire and s.idService = ?");
                pstm.setInt(1,getIdServiceByService(serv));
                ResultSet rs= pstm.executeQuery();

                while (rs.next()){
                    TreeClass e=new TreeClass(rs.getString("cni"), rs.getString("nom"), rs.getString("prenom"), rs.getString("etablissement"), rs.getString("specialite"), getEncadrantByIdEncadrant(rs.getInt("idEncadrant")), getServiceByIdService(rs.getInt("idService")),  getDemandeurByIdDemandeur(rs.getInt("idDemandeur")), rs.getString("theme"), rs.getString("type"), rs.getDate("dateDebut"), rs.getDate("dateFin"));

                    stagiaires.add(e);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            return stagiaires;
        }
        public ArrayList<TreeClass> getAllStagiairesByEncadrant(String enc){
            Connection conn = SignletonConnexionDB.getConnection();
            ArrayList<TreeClass> stagiaires = new ArrayList();

            try {
                PreparedStatement pstm=conn.prepareStatement("select * from stagiaire s,stage st, effectuer ef where ef.idStage = st.idStage and ef.idStagiaire = s.idStagiaire and s.idEncadrant = ?");
                pstm.setInt(1,getIdEncadrantByEncadrant(enc));
                ResultSet rs= pstm.executeQuery();

                while (rs.next()){
                    TreeClass e=new TreeClass(rs.getString("cni"), rs.getString("nom"), rs.getString("prenom"), rs.getString("etablissement"), rs.getString("specialite"), getEncadrantByIdEncadrant(rs.getInt("idEncadrant")), getServiceByIdService(rs.getInt("idService")),  getDemandeurByIdDemandeur(rs.getInt("idDemandeur")), rs.getString("theme"), rs.getString("type"), rs.getDate("dateDebut"), rs.getDate("dateFin"));

                    stagiaires.add(e);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            return stagiaires;
        }
        public  ArrayList<service> getAllServices(){
            Connection conn=SignletonConnexionDB.getConnection();
            ArrayList<service> services=new ArrayList<>();
            try {
                PreparedStatement pstm=conn.prepareStatement("select * from service");
                ResultSet rs= pstm.executeQuery();
                while (rs.next()){
                    service e  = new service(rs.getInt("idService"), rs.getString("intitule"));
                    services.add(e);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return services;
        }

        public  ArrayList<demandeur> getAllDemandeurs(){
            Connection conn=SignletonConnexionDB.getConnection();
            ArrayList<demandeur> demandeurs=new ArrayList<>();
            try {
                PreparedStatement pstm=conn.prepareStatement("select * from demandeur");
                ResultSet rs= pstm.executeQuery();
                while (rs.next()){
                    demandeur  d = new demandeur(rs.getInt("idDemandeur"), rs.getString("nom"));
                    demandeurs.add(d);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return demandeurs;
        }


        public boolean connecter(String user, String password){
           // if(user.equalsIgnoreCase("admin") && password.equalsIgnoreCase("123"))
             //   return true;
            Connection conn = SignletonConnexionDB.getConnection();

            try {
                PreparedStatement pstm = conn.prepareStatement("select * from utilisateur where user = ? and password=? ");
                pstm.setString(1, user);
                pstm.setString(2, password);
                ResultSet rs = pstm.executeQuery();
                if (rs.next()) {
                    return true;
                }
            } catch (Exception var6) {
                var6.printStackTrace();
            }

            return false;
        }
        public  stagiaire getStagiaireByCNI(String CNI){
            Connection conn = SignletonConnexionDB.getConnection();

            try {
                PreparedStatement pstm = conn.prepareStatement("select * from stagiaire where cni = ? ");
                pstm.setString(1, CNI);
                ResultSet rs = pstm.executeQuery();
                rs.next();
                return new stagiaire(rs.getString("cni"),rs.getString("nom"),rs.getString("prenom"),rs.getString("etablissement"),rs.getString("specialite"),getEncadrantByIdEncadrant(rs.getInt("idEncadrant")),getServiceByIdService(rs.getInt("idService")),getDemandeurByIdDemandeur(rs.getInt("idDemandeur")));

            } catch (Exception var5) {
                var5.printStackTrace();
                return null;
            }
        }
        public int getIdStagiaireByCNI(String CNI){
            Connection conn = SignletonConnexionDB.getConnection();

            try {
                PreparedStatement pstm = conn.prepareStatement("select idStagiaire from stagiaire where cni = ? ");
                pstm.setString(1, CNI);
                ResultSet rs = pstm.executeQuery();
                rs.next();
                return rs.getInt("idStagiaire");
            } catch (Exception var5) {
                var5.printStackTrace();
                return -1;
            }
        }
            int j=0;
        public void addStagiaire(TreeClass t){
            Connection conn = SignletonConnexionDB.getConnection();

            try {

                PreparedStatement pstm = conn.prepareStatement("insert into stagiaire(cni,nom,prenom,etablissement,specialite,idEncadrant,idService,idDemandeur) values (?,?,?,?,?,?,?,?)");
                pstm.setString(1, t.getCni());
                pstm.setString(2, t.getNom());
                pstm.setString(3, t.getPrenom());
                pstm.setString(4, t.getEtablissement());
                pstm.setString(5, t.getSpecialite());
                pstm.setInt(6,getIdEncadrantByEncadrant(t.getNomEncadrant()) );
                pstm.setInt(7,getIdServiceByService(t.getIntituleService()));
                pstm.setInt(8, getIdDemandeurByDemandeur(t.getNomDemandeur()));

                pstm.executeUpdate();

                PreparedStatement pstm3 = conn.prepareStatement("SELECT COUNT(*) AS rowcount FROM stage ");
                ResultSet rs = pstm3.executeQuery();
                rs.next();
                //j = rs.getRow();
                j = rs.getInt("rowcount");

                System.out.println(j);

                PreparedStatement pstm1 = conn.prepareStatement("insert into stage(idStage,theme,type) values (?,?,?)");
                pstm1.setInt(1, ++j);
                pstm1.setString(2, t.getTheme());
                pstm1.setString(3, t.getType());
                pstm1.executeUpdate();


                PreparedStatement pstm2 = conn.prepareStatement("insert into effectuer values (?,?,?,?)");

                pstm2.setInt(1, getIdStagiaireByCNI(t.getCni()));
                pstm2.setInt(2, j);
                Date dateD=new java.sql.Date(t.getDateDebut().getTime());
                Date dateF=new java.sql.Date(t.getDateFin().getTime());
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String strDateD = dateFormat.format(dateD);
                String strDateF = dateFormat.format(dateF);
                pstm2.setString(3, strDateD);
                pstm2.setString(4, strDateF);
                pstm2.executeUpdate();


            } catch (Exception var4) {
                var4.printStackTrace();
            }

        }
        public void addEncadrant(encadrant e){
            Connection conn = SignletonConnexionDB.getConnection();
            try {
                PreparedStatement pstm = conn.prepareStatement("insert into encadrant(nom,fonction,division,unite,tele) values (?,?,?,?,?)");
                pstm.setString(1, e.getNom());
                pstm.setString(2, e.getFonction());
                pstm.setString(3, e.getDivision());
                pstm.setString(4, e.getUnite());
                pstm.setString(5, e.getTel());
                pstm.executeUpdate();
            }

            catch (Exception var4) {
                var4.printStackTrace();
            }
        }

        public void addService(service s){
            Connection conn = SignletonConnexionDB.getConnection();
            try {
                PreparedStatement pstm = conn.prepareStatement("insert into service(intitule) values (?)");
                pstm.setString(1, s.getIntitule());
                pstm.executeUpdate();
            }

            catch (Exception var4) {
                var4.printStackTrace();
            }
        }

        public void addDemandeur(demandeur d){
            Connection conn = SignletonConnexionDB.getConnection();
            try {
                PreparedStatement pstm = conn.prepareStatement("insert into demandeur(nom) values (?)");
                pstm.setString(1, d.getNom());
                pstm.executeUpdate();
            }

            catch (Exception var4) {
                var4.printStackTrace();
            }
        }

        public void deleteStagiaire(TreeClass t){

            Connection conn = SignletonConnexionDB.getConnection();

            try {


                PreparedStatement pstm2 = conn.prepareStatement("delete from effectuer where idStagiaire=? and idStage=(select idStage from effectuer where idStagiaire=?)");
                pstm2.setInt(1, getIdStagiaireByCNI(t.getCni()));
                pstm2.setInt(2, getIdStagiaireByCNI(t.getCni()));
                pstm2.executeUpdate();

                PreparedStatement pstm1 = conn.prepareStatement("delete from stage where idStage=(select idStage from effectuer where idStagiaire=?)");
                pstm1.setInt(1, getIdStagiaireByCNI(t.getCni()));
                pstm1.executeUpdate();

                PreparedStatement pstm = conn.prepareStatement("delete from stagiaire where cni = ?");
                pstm.setString(1, t.getCni());
                pstm.executeUpdate();

            } catch (Exception var4) {
                var4.printStackTrace();
            }

        }

        public void deleteEncadrant(encadrant e){
            Connection conn = SignletonConnexionDB.getConnection();
            try {
                PreparedStatement pstm = conn.prepareStatement("delete from encadrant where idEncadrant = ?");
                pstm.setInt(1,getIdEncadrantByEncadrant(e.getNom()));
                pstm.executeUpdate();
            }
            catch (Exception var4) {
                var4.printStackTrace();
            }
        }

        public void deleteService(service s){
            Connection conn = SignletonConnexionDB.getConnection();
            try {
                PreparedStatement pstm = conn.prepareStatement("delete from service where idService = ?");
                pstm.setInt(1, s.getIdService());
                pstm.executeUpdate();
            }
            catch (Exception var4) {
                var4.printStackTrace();
            }
        }

        public void deleteDemandeur(demandeur d){
            Connection conn = SignletonConnexionDB.getConnection();
            try {
                PreparedStatement pstm = conn.prepareStatement("delete from demandeur where idDemandeur = ?");
                pstm.setInt(1, d.getIdDemandeur());
                pstm.executeUpdate();
            }
            catch (Exception var4) {
                var4.printStackTrace();
            }
        }

        public void updateStagiaire(TreeClass s){

            Connection conn = SignletonConnexionDB.getConnection();

            try {
                PreparedStatement pstm = conn.prepareStatement("update stagiaire set nom=?,prenom=?,etablissement=?,specialite=?,idEncadrant=?,idService=?,idDemandeur=? where cni= ? ");
                pstm.setString(8, s.getCni());
                pstm.setString(1, s.getNom());
                pstm.setString(2, s.getPrenom());
                pstm.setString(3, s.getEtablissement());
                pstm.setString(4, s.getSpecialite());
                pstm.setInt(5,getIdEncadrantByEncadrant(s.getNomEncadrant()) );
                pstm.setInt(6,getIdServiceByService(s.getIntituleService()));
                pstm.setInt(7, getIdDemandeurByDemandeur(s.getNomDemandeur()));
                pstm.executeUpdate();


                PreparedStatement pstm1 = conn.prepareStatement("update stage set theme=?, type=? where idStage=(select idStage from effectuer where idStagiaire=?)");
                pstm1.setString(1, s.getTheme());
                pstm1.setString(2, s.getType());
                pstm1.setInt(3, getIdStagiaireByCNI(s.getCni()));
                pstm1.executeUpdate();



                PreparedStatement pstm2 = conn.prepareStatement("update effectuer set dateDebut=?, dateFin=? where idStagiaire=? and idStage=(select idStage from effectuer where idStagiaire=?)");
                pstm2.setInt(3, getIdStagiaireByCNI(s.getCni()));
                pstm2.setInt(4, getIdStagiaireByCNI(s.getCni()));
                pstm2.setDate(1, new java.sql.Date(s.getDateDebut().getTime()));
                pstm2.setDate(2, new java.sql.Date(s.getDateFin().getTime()));
                pstm2.executeUpdate();

            } catch (Exception var4) {
                var4.printStackTrace();
            }
        }
        public void updateEncadrant(encadrant e){
            Connection conn = SignletonConnexionDB.getConnection();

            try {
                PreparedStatement pstm = conn.prepareStatement("update encadrant set nom=?,fonction=?,division=?,unite=?,tele=? where idEncadrant= ? ");
                pstm.setString(1, e.getNom());
                pstm.setString(2, e.getFonction());
                pstm.setString(3, e.getDivision());
                pstm.setString(4, e.getUnite());
                pstm.setString(5, e.getTel());
                pstm.setInt(6,getIdEncadrantByEncadrant(e.getNom()));
                pstm.executeUpdate();
            } catch (Exception var4) {
                var4.printStackTrace();
            }
        }

        public void updateService(service s){
            Connection conn = SignletonConnexionDB.getConnection();

            try {
                PreparedStatement pstm = conn.prepareStatement("update service set intitule=? where idService= ? ");
                pstm.setString(1, s.getIntitule());
                pstm.setInt(2, s.getIdService());
                pstm.executeUpdate();
            } catch (Exception var4) {
                var4.printStackTrace();
            }
        }

        public void updateDemandeur(demandeur d){
            Connection conn = SignletonConnexionDB.getConnection();

            try {
                PreparedStatement pstm = conn.prepareStatement("update demandeur set nom=? where idDemandeur= ? ");
                pstm.setString(1, d.getNom());
                pstm.setInt(2, d.getIdDemandeur());
                pstm.executeUpdate();
            } catch (Exception var4) {
                var4.printStackTrace();
            }
        }

        public ArrayList<String> getAllEncadrant() {
        Connection conn=SignletonConnexionDB.getConnection();
        ArrayList<String> encadrants=new ArrayList<>();
        try {
            PreparedStatement pstm=conn.prepareStatement("select nom from encadrant");
            ResultSet rs= pstm.executeQuery();
            while (rs.next()){
                String nomE= rs.getString("nom");

                encadrants.add(nomE);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  encadrants;
    }
    public ArrayList<encadrant> getAllEncadrantsTable() {
        Connection conn=SignletonConnexionDB.getConnection();
        ArrayList<encadrant> encadrants=new ArrayList<>();
        try {
            PreparedStatement pstm=conn.prepareStatement("select * from encadrant");
            ResultSet rs= pstm.executeQuery();
            while (rs.next()){
                encadrant e = new encadrant(rs.getInt("idEncadrant"),rs.getString("nom"),rs.getString("fonction"),rs.getString("division"),rs.getString("unite"),rs.getString("tele"));

                encadrants.add(e);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  encadrants;
    }
    public ArrayList<String> getAllServiceIntitule() {
        Connection conn=SignletonConnexionDB.getConnection();
        ArrayList<String> services=new ArrayList<>();
        try {
            PreparedStatement pstm=conn.prepareStatement("select intitule from service");
            ResultSet rs= pstm.executeQuery();
            while (rs.next()){
                String serviceI= rs.getString("intitule");

                services.add(serviceI);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  services;
    }

    public ArrayList<String> getAllNomDemandeurs() {
        Connection conn=SignletonConnexionDB.getConnection();
        ArrayList<String> demandeurs=new ArrayList<>();
        try {
            PreparedStatement pstm=conn.prepareStatement("select nom from demandeur");
            ResultSet rs= pstm.executeQuery();
            while (rs.next()){
                String nomDem= rs.getString("nom");

                demandeurs.add(nomDem);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  demandeurs;
    }

    public int getIdStageByIdStagiaire(stagiaire s){
        Connection conn = SignletonConnexionDB.getConnection();
        int stages ;

        try {
            PreparedStatement pstm = conn.prepareStatement("select * from effectuer where idStagiaire = ?");
            pstm.setInt(1, getIdStagiaireByCNI(s.getCni()));
            ResultSet rs = pstm.executeQuery();
            rs.next();
            stage sta = new stage(rs.getString("theme"),rs.getString("type"),rs.getBoolean("observation"),rs.getBoolean("rapport"),rs.getBoolean("attestation"));
            return sta.getIdStage();
        } catch (Exception var7) {
            var7.printStackTrace();
            return -1;
        }

    }



    public ArrayList<TreeClass> getAllStagiairesTable(){
        Connection conn=SignletonConnexionDB.getConnection();
        ArrayList<TreeClass> stagiaires=new ArrayList<>();
        try {
            PreparedStatement pstm=conn.prepareStatement("select * from stagiaire s,stage st, effectuer ef where ef.idStage = st.idStage and ef.idStagiaire = s.idStagiaire");
            ResultSet rs= pstm.executeQuery();

            while (rs.next()){


               // SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss", Locale.ENGLISH);
                //Date formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss", strDate);
                Date dateDebut = new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString("dateDebut"));
                Date dateFin=new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString("dateFin"));
                //Date dateD = formatter.parse(DD);
                //Date dateF = formatter.parse(DF);

                TreeClass e=new TreeClass(rs.getString("cni"), rs.getString("nom"), rs.getString("prenom"), rs.getString("etablissement"), rs.getString("specialite"), getEncadrantByIdEncadrant(rs.getInt("idEncadrant")), getServiceByIdService(rs.getInt("idService")),  getDemandeurByIdDemandeur(rs.getInt("idDemandeur")), rs.getString("theme"), rs.getString("type"), dateDebut, dateFin);

                stagiaires.add(e);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return stagiaires;
    }

    public imprimerClass serchByCin(String CIN){

        Connection conn = SignletonConnexionDB.getConnection();

        try {
            PreparedStatement pstm = conn.prepareStatement("select * from stagiaire where cni = ? ");
            pstm.setString(1, CIN);
            ResultSet rs = pstm.executeQuery();

            rs.next();
            int en=rs.getInt("idEncadrant");
            String nom=rs.getString("nom");
            String prenom = rs.getString("prenom");
            String etab = rs.getString("etablissement");
            String spec =rs.getString("specialite");


            PreparedStatement pstm1 = conn.prepareStatement("select * from effectuer where idStagiaire = ? ");
            pstm1.setInt(1, rs.getInt("idStagiaire"));
            ResultSet rs1 = pstm1.executeQuery();

            rs1.next();
            int sta=rs1.getInt("idStage");
            Date dD=rs1.getDate("dateDebut");
            Date dF=rs1.getDate("dateFin");


            PreparedStatement pstm2 = conn.prepareStatement("select * from stage where idStage = ? ");
            pstm2.setInt(1, sta);
            //System.out.println( rs1.getInt("idStage"));
            ResultSet rs2 = pstm2.executeQuery();
            rs2.next();
            String theme =rs2.getString("theme");
            PreparedStatement pstm3 = conn.prepareStatement("select * from encadrant where idEncadrant = ? ");
            pstm3.setInt(1, en);
            ResultSet rs3 = pstm3.executeQuery();
            rs3.next();

            imprimerClass imp=new imprimerClass(CIN,nom,prenom,etab,spec,theme, rs3.getString("nom"), rs3.getString("division"),rs3.getString("unite"),rs3.getString("tele"),dD,dF,rs3.getString("fonction") );
          //  imprimerClass imp1=new imprimerClass("cin1","1","1","1","1","1","1","1","1","1","1/01/2022","3/01/2022");
            return imp;
        } catch (Exception var5) {
            var5.printStackTrace();
            return null;
        }
    }

    public int NbStagiaires(Date dateD, Date dateF) {
        Connection conn = SignletonConnexionDB.getConnection();
        try {
            PreparedStatement pstm = conn.prepareStatement("SELECT COUNT(*) AS rowcount FROM stagiaire s,effectuer e where s.idStagiaire=e.idStagiaire and (e.dateDebuT between ? and ?) and (e.dateFin between ? and ?)");
            pstm.setDate(1, new java.sql.Date(dateD.getTime()));
            pstm.setDate(2, new java.sql.Date(dateF.getTime()));
            pstm.setDate(3, new java.sql.Date(dateD.getTime()));
            pstm.setDate(4, new java.sql.Date(dateF.getTime()));
            ResultSet rs = pstm.executeQuery();
            rs.next();

            int row = rs.getInt("rowcount");

            return row;
        } catch (Exception var5) {
            var5.printStackTrace();
            return -1;
        }

    }
    int row=0;
    public int NbStagiaireYearService(Date dateD, Date dateF, String service) {
        Connection conn = SignletonConnexionDB.getConnection();
        try {
            PreparedStatement pstm = conn.prepareStatement("SELECT COUNT(*) AS rowcount FROM stagiaire s,effectuer e where s.idStagiaire=e.idStagiaire and (e.dateDebuT between ? and ?) and (e.dateFin between ? and ?) and s.idService=?");
            pstm.setDate(1, new java.sql.Date(dateD.getTime()));
            pstm.setDate(2, new java.sql.Date(dateF.getTime()));
            pstm.setDate(3, new java.sql.Date(dateD.getTime()));
            pstm.setDate(4, new java.sql.Date(dateF.getTime()));
            pstm.setInt(5, getIdServiceByService(service));
            ResultSet rs = pstm.executeQuery();
            rs.next();

            row = rs.getInt("rowcount");
            System.out.println(row);

            return row;
        } catch (Exception var5) {
            var5.printStackTrace();
            return -1;
        }

    }


}
