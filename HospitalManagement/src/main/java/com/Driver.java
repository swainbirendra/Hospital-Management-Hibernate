package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Driver {

	public static void main(String[] args) {
		
		entercase();
		
		}
	public static void entercase() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("girish");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter case: ");
		int n = sc.nextInt();
		switch(n) {
		case 1:
		et.begin();
		Doctor d1 = new Doctor();
		System.out.println("Enter Doctor Name: ");
		d1.setName(sc.next());
		System.out.println("Enter Doctor Type: ");
		d1.setType(sc.next());
		
		Patient p1 = new Patient();
		System.out.println("Enter Patient name: ");
		p1.setName(sc.next());
		System.out.println("Enter Patient Disease:");
		p1.setDisies(sc.next());
		System.out.println("Enter Patient Age: ");
		p1.setAge(sc.nextInt());
		
		Preciption pp1 = new Preciption();
		System.out.println("Eneter Prescription: ");
		pp1.setName(sc.next());
		System.out.println("Enter Date: ");
		pp1.setDate(sc.next());
		System.out.println("Enter Total Amount: ");
		pp1.setCost(sc.nextInt());
		
		List<Patient>patient=new ArrayList<Patient>();
		patient.add(p1);
		d1.setPatient(patient);
		p1.setPreciption(pp1);
		em.persist(d1);
		em.persist(p1);
		em.persist(pp1);
		et.commit();
		break;
		case 2:System.out.println("fetch Doctor data");
		et.begin();
		System.out.println("Enter id:");
		int id=sc.nextInt();
		Doctor d2 = em.find(Doctor.class, id);
		if (d2 != null) {
		System.out.println("Enter Docter Name: "+d2.getName());
		System.out.println("Enter Doctor Type: "+d2.getType());
		}
		em.persist(d2);
		et.commit();
		break;
		case 3:System.out.println("fetch Patient data");
		et.begin();
		System.out.println("Enter id:");
		int id1=sc.nextInt();
		Patient p2 = em.find(Patient.class, id1);
		if (p2 != null) {
			System.out.println("Patient Name: "+p2.getName());
			System.out.println("Patient Disease: "+p2.getDisies());
			System.out.println("Pateient Age: "+p2.getAge());
		}
		em.persist(p2);
		et.commit();
		break;
		case 4:System.out.println("fetch Preciption data");
		et.begin();
		System.out.println("Enter id:");
		int id2=sc.nextInt();
		Preciption pp2 = em.find(Preciption.class, id2);
		if (pp2 != null) {
			System.out.println("preciption Name:"+pp2.getName());
			System.out.println("preciption Date:"+pp2.getDate());
			System.out.println("preciption Cost"+pp2.getCost());
		}		
		em.persist(pp2);
		et.commit();
		break;
		case 5:System.out.println("update Doctor Data");
		et.begin();
		System.out.println("Enter id:");
		int id3=sc.nextInt();
			Doctor d3 = em.find(Doctor.class, id3);
			if (d3 != null) {
				System.out.println("Enter Doctor Name:");
				d3.setName(sc.next());
				System.out.println("Enter Doctor Type:");
				d3.setType(sc.next());
			}
			em.merge(d3);
			et.commit();
			break;
		case 6:System.out.println("update Patient Data");
		et.begin();
		System.out.println("Enter id:");
		int id4=sc.nextInt();
			Patient p3 = em.find(Patient.class, id4);
			if (p3 != null) {
				System.out.println("Enter Patient Name:");
				p3.setName(sc.next());
				System.out.println("Enter Patient Disease:");
				p3.setDisies(sc.next());
				System.out.println("Enter Patient Age:");
				p3.setAge(sc.nextInt());
			}
			em.merge(p3);
			et.commit();
			break;
		case 7:System.out.println("update Prescription Data");
		et.begin();
		System.out.println("Enter id:");
		int id5=sc.nextInt();
			Preciption pp3 = em.find(Preciption.class, id5);
			if (pp3 != null) {
				System.out.println("Prescription Name:");
				pp3.setName(sc.next());
				System.out.println("Prescription Date");
				pp3.setDate(sc.next());
				System.out.println("Prescription Cost");
				pp3.setCost(sc.nextInt());
			}		
			em.merge(pp3);
			et.commit();
			break;
		case 8:System.out.println("delete data");
		et.begin();
		System.out.println("Enter id:");
		int id6=sc.nextInt();
		Doctor d4 = em.find(Doctor.class, id6);
		if (d4 != null) {
			em.remove(d4);
		}
		Patient p4 = em.find(Patient.class, id6);
		if (p4 != null) {
			em.remove(p4);
		}
		Preciption pp4 = em.find(Preciption.class, id6);
		if (pp4 != null) {
			em.remove(pp4);
		}
		em.persist(d4);
		em.persist(p4);
		em.persist(pp4);
		et.commit();
		break;
		}
		entercase();
		}
		
	}

	

