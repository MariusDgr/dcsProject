package Test;

import java.util.ArrayList;

import Components.Activation;
import Components.Condition;
import Components.GuardMapping;
import Components.PetriNet;
import Components.PetriNetWindow;
import Components.PetriTransition;
import DataObjects.DataCar;
import DataObjects.DataCarQueue;
import DataObjects.DataString;
import DataObjects.DataTransfer;
import DataOnly.Car;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Lanes_Intersection_Final {
	public static void main(String[] args) {

		// --------------------------------------------------------------------
		// -------------------------------Lane1--------------------------------
		// --------------------------------------------------------------------

		PetriNet pn = new PetriNet();
		pn.PetriNetName = "Lanes Intersection";

		DataString green = new DataString();
		green.Printable = false;
		green.SetName("green");
		green.SetValue("green");
		pn.PlaceList.add(green);

		DataCar p1 = new DataCar();
		p1.SetName("P_a1");
		pn.PlaceList.add(p1);

		DataCarQueue p2 = new DataCarQueue();
		p2.Value.Size = 3;
		p2.SetName("P_x1");
		pn.PlaceList.add(p2);

		DataString p3 = new DataString();
		p3.SetName("P_TL1");
		pn.PlaceList.add(p3);

		DataCar p4 = new DataCar();
		p4.SetName("P_b1");
		pn.PlaceList.add(p4);

		// -------------------------------------------------------------------------------------
		// --------------------------------Lane 2-----------------------------------------------
		// -------------------------------------------------------------------------------------
		
		DataCar p5 = new DataCar(); //p5.Printable = false;
		p5.SetName("P_a2");
		pn.PlaceList.add(p5);

		DataCarQueue p6 = new DataCarQueue(); //p6.Printable = false;
		p6.Value.Size = 3;
		p6.SetName("P_x2");
		pn.PlaceList.add(p6);

		DataString p7 = new DataString(); //p7.Printable = false;
		p7.SetName("P_TL2");
		pn.PlaceList.add(p7);

		DataCar p8 = new DataCar(); //p8.Printable = false;
		p8.SetName("P_b2");
		pn.PlaceList.add(p8);

		// -------------------------------------------------------------------------------------
		// --------------------------------Lane 3-----------------------------------------------
		// -------------------------------------------------------------------------------------

		DataCar p9 = new DataCar(); //p9.Printable = false;
		p9.SetName("P_a3");
		pn.PlaceList.add(p9);

		DataCarQueue p10 = new DataCarQueue(); //p10.Printable = false;
		p10.Value.Size = 3;
		p10.SetName("P_x3");
		pn.PlaceList.add(p10);

		DataString p11 = new DataString(); //p11.Printable = false;
		p11.SetName("P_TL3");
		pn.PlaceList.add(p11);

		DataCar p12 = new DataCar(); //p12.Printable = false;
		p12.SetName("P_b3");
		pn.PlaceList.add(p12);

		// -------------------------------------------------------------------------------------
		// --------------------------------Lane 4-----------------------------------------------
		// -------------------------------------------------------------------------------------

		//DataCar p13 = new DataCar(); out of action
		//p13.SetName("P_a4"); 
		//pn.PlaceList.add(p13); 

		DataCarQueue p14 = new DataCarQueue();
		p14.Value.Size = 3;
		p14.SetName("P_x4");
		pn.PlaceList.add(p14);

		DataString p15 = new DataString();
		p15.SetName("P_TL4");
		pn.PlaceList.add(p15);

		DataCar p16 = new DataCar();
		p16.SetName("P_b4");
		pn.PlaceList.add(p16);
		
		// --------------------------------------------------------------------
		// -------------------------------Lane5--------------------------------
		// --------------------------------------------------------------------

		

		//DataCar p17 = new DataCar();
		//p17.SetName("P_a5");
		//pn.PlaceList.add(p17);

		DataCarQueue p18 = new DataCarQueue();
		p18.Value.Size = 3;
		p18.SetName("P_x5");
		pn.PlaceList.add(p18);

		DataString p19 = new DataString();
		p19.SetName("P_TL5");
		pn.PlaceList.add(p19);

		DataCar p20 = new DataCar();
		p20.SetName("P_b5");
		pn.PlaceList.add(p20);
		
		// -------------------------------------------------------------------------------------
		// --------------------------------Lane 6-----------------------------------------------
		// -------------------------------------------------------------------------------------
		
		DataCar p21 = new DataCar(); //p5.Printable = false;
		p21.SetName("P_a6");
		pn.PlaceList.add(p21);

		DataCarQueue p22 = new DataCarQueue(); //p6.Printable = false;
		p22.Value.Size = 3;
		p22.SetName("P_x6");
		pn.PlaceList.add(p22);

		DataString p23 = new DataString(); //p7.Printable = false;
		p23.SetName("P_TL6");
		pn.PlaceList.add(p23);

		DataCar p24 = new DataCar(); //p8.Printable = false;
		p24.SetName("P_b6");
		pn.PlaceList.add(p24);

		
		// -------------------------------------------------------------------------------------
		// --------------------------------Lane 7-----------------------------------------------
		// -------------------------------------------------------------------------------------

		DataCar p25 = new DataCar(); //p9.Printable = false;
		p25.SetName("P_a7");
		pn.PlaceList.add(p25);

		DataCarQueue p26 = new DataCarQueue(); //p10.Printable = false;
		p26.Value.Size = 3;
		p26.SetName("P_x7");
		pn.PlaceList.add(p26);

		DataString p27 = new DataString(); //p11.Printable = false;
		p27.SetName("P_TL7");
		pn.PlaceList.add(p27);

		DataCar p28 = new DataCar(); //p12.Printable = false;
		p28.SetName("P_b7");
		pn.PlaceList.add(p28);
		// ----------------------------------------------------------------------------
		// ----------------------------Exit lane 1-------------------------------------
		// ----------------------------------------------------------------------------

		DataCarQueue p29 = new DataCarQueue(); 
		p29.Printable = false;
		p29.Value.Size = 3;
		p29.SetName("P_o1");
		pn.PlaceList.add(p29);

		DataCar p30 = new DataCar(); 
		p30.Printable = false;
		p30.SetName("P_o1Exit");
		pn.PlaceList.add(p30);

		// ----------------------------------------------------------------------------
		// ----------------------------Exit lane 2-------------------------------------
		// ----------------------------------------------------------------------------

		DataCarQueue p31 = new DataCarQueue(); 
		p31.Printable = false;
		p31.Value.Size = 3;
		p31.SetName("P_o2");
		pn.PlaceList.add(p31);

		DataCar p32 = new DataCar();
		p32.Printable = false;
		p32.SetName("P_o2Exit");
		pn.PlaceList.add(p32);

		// ----------------------------------------------------------------------------
		// ----------------------------Exit lane 3-------------------------------------
		// ----------------------------------------------------------------------------

		DataCarQueue p33 = new DataCarQueue();
		p33.Printable = false;
		p33.Value.Size = 3;
		p33.SetName("P_o3");
		pn.PlaceList.add(p33);

		DataCar p34 = new DataCar();
		p34.Printable = false;
		p34.SetName("P_o3Exit");
		pn.PlaceList.add(p34);

		// ----------------------------------------------------------------------------
		// ----------------------------Exit lane 4-------------------------------------
		// ----------------------------------------------------------------------------

//		DataCarQueue p35 = new DataCarQueue();
//		p35.Value.Size = 3;
//		p35.SetName("P_o4");
//		pn.PlaceList.add(p35);
//
//		DataCar p36 = new DataCar();
//		p36.SetName("P_o4Exit");
//		pn.PlaceList.add(p36);
		
		// ----------------------------------------------------------------------------
		// ----------------------------Exit lane 5-------------------------------------
		// ----------------------------------------------------------------------------

//		DataCarQueue p37 = new DataCarQueue();
//		p37.Printable = false;
//		p37.Value.Size = 3;
//		p37.SetName("P_o5");
//		pn.PlaceList.add(p37);
//
//		DataCar p38 = new DataCar();
//		p38.Printable = false;
//		p38.SetName("P_o5Exit");
//		pn.PlaceList.add(p38);
		
		// ----------------------------------------------------------------------------
		// ----------------------------Exit lane 6-------------------------------------
		// ----------------------------------------------------------------------------

		DataCarQueue p39 = new DataCarQueue();
		p39.Printable = false;
		p39.Value.Size = 3;
		p39.SetName("P_o6");
		pn.PlaceList.add(p39);

		DataCar p40 = new DataCar();
		p40.Printable = false;
		p40.SetName("P_o6Exit");
		pn.PlaceList.add(p40);

		// ----------------------------------------------------------------------------
		// ----------------------------Exit lane 7-------------------------------------
		// ----------------------------------------------------------------------------

		DataCarQueue p41 = new DataCarQueue();
		p41.Printable = false;
		p41.Value.Size = 3;
		p41.SetName("P_o7");
		pn.PlaceList.add(p41);

		DataCar p42 = new DataCar();
		p42.Printable = false;
		p42.SetName("P_o7Exit");
		pn.PlaceList.add(p42);

		// -------------------------------------------------------------------------------------------
		// --------------------------------Intersection-----------------------------------------------
		// -------------------------------------------------------------------------------------------

		DataCarQueue p43 = new DataCarQueue();
		p43.Value.Size = 3;
		p43.SetName("P_IR");//right intersection node
		pn.PlaceList.add(p43);
		
		DataCarQueue p44 = new DataCarQueue();
		p44.Value.Size = 3;
		p44.SetName("P_IL");//left intersection node
		pn.PlaceList.add(p44);
		
		// ------------------------ Sensors for intelligent cycles

        DataTransfer ps1 = new DataTransfer();
		ps1.SetName("SENSOR1");
		ps1.Value = new TransferOperation("localhost", "1081", "SENSOR1C");
		pn.PlaceList.add(ps1);
        
        DataTransfer ps2 = new DataTransfer();
		ps2.SetName("SENSOR2");
		ps2.Value = new TransferOperation("localhost", "1081", "SENSOR2C");
		pn.PlaceList.add(ps2);
        
        DataTransfer ps3 = new DataTransfer();
		ps3.SetName("SENSOR3");
		ps3.Value = new TransferOperation("localhost", "1081", "SENSOR3C");
		pn.PlaceList.add(ps3);
        
        DataTransfer ps4 = new DataTransfer();
		ps4.SetName("SENSOR4");
		ps4.Value = new TransferOperation("localhost", "1081", "SENSOR4C");
		pn.PlaceList.add(ps4);
        
        DataTransfer ps5 = new DataTransfer();
		ps5.SetName("SENSOR5");
		ps5.Value = new TransferOperation("localhost", "1081", "SENSOR5C");
		pn.PlaceList.add(ps5);
             
        DataTransfer ps6 = new DataTransfer();
		ps6.SetName("SENSOR6");
		ps6.Value = new TransferOperation("localhost", "1081", "SENSOR6C");
		pn.PlaceList.add(ps6);
          
        DataTransfer ps7 = new DataTransfer();
		ps7.SetName("SENSOR7");
		ps7.Value = new TransferOperation("localhost", "1081", "SENSOR7C");
		pn.PlaceList.add(ps7);
        
		// -------------------------------- Sensor place

        DataString car1 = new DataString();
		car1.SetName("car1");
		car1.SetValue("car1");
		pn.PlaceList.add(car1);
          
        DataString car2 = new DataString();
		car2.SetName("car2");
		car2.SetValue("car2");
		pn.PlaceList.add(car2);
        
        DataString car3 = new DataString();
		car3.SetName("car3");
		car3.SetValue("car3");
		pn.PlaceList.add(car3);
        
        DataString car4 = new DataString();
		car4.SetName("car4");
		car4.SetValue("car4");
		pn.PlaceList.add(car4);
          
        DataString car5 = new DataString();
		car5.SetName("car5");
		car5.SetValue("car5");
		pn.PlaceList.add(car5);
         
        DataString car6 = new DataString();
		car6.SetName("car6");
		car6.SetValue("car6");
		pn.PlaceList.add(car6);
           
        DataString car7 = new DataString();
		car7.SetName("car7");
		car7.SetValue("car7");
		pn.PlaceList.add(car7);
        
        	
		// -------------------------------------------------------------------------------------------
		// --------------------------------Transitions-----------------------------------------------
		// ------------------------------------------------------------------------------------------- 

		// T1 ------------------------------------------------
		PetriTransition t1 = new PetriTransition(pn);
		t1.TransitionName = "T_u1";
		t1.InputPlaceName.add("P_a1");
		t1.InputPlaceName.add("car1");

		Condition T1Ct1 = new Condition(t1, "P_a1", TransitionCondition.NotNull);
		Condition T1Ct2 = new Condition(t1, "P_x1", TransitionCondition.CanAddCars);
		T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

		GuardMapping grdT1 = new GuardMapping();
		grdT1.condition = T1Ct1;
		grdT1.Activations.add(new Activation(t1, "car1", TransitionOperation.AddElement, "SENSOR1C"));
		grdT1.Activations.add(new Activation(t1, "car1", TransitionOperation.AddElement, "car1"));
		grdT1.Activations.add(new Activation(t1, "P_a1", TransitionOperation.AddElement, "P_x1"));
		t1.GuardMappingList.add(grdT1);

		t1.Delay = 0;
		pn.Transitions.add(t1);

		// T2 ------------------------------------------------
		PetriTransition t2 = new PetriTransition(pn);
		t2.TransitionName = "T_e1";
		t2.InputPlaceName.add("P_x1");
		t2.InputPlaceName.add("P_TL1");

		Condition T2Ct1 = new Condition(t2, "P_TL1", TransitionCondition.Equal, "green");
		Condition T2Ct2 = new Condition(t2, "P_x1", TransitionCondition.HaveCar);
		T2Ct1.SetNextCondition(LogicConnector.AND, T2Ct2);

		GuardMapping grdT2 = new GuardMapping();
		grdT2.condition = T2Ct1;
		grdT2.Activations.add(new Activation(t2, "P_x1", TransitionOperation.PopElementWithoutTarget, "P_b1"));
	    grdT2.Activations.add(new Activation(t2, "P_TL1", TransitionOperation.Move, "P_TL1"));
	    
		t2.GuardMappingList.add(grdT2);

//		t2.Delay = 3; TODO
		pn.Transitions.add(t2);

		// T3 ------------------------------------------------
		PetriTransition t3 = new PetriTransition(pn);
		t3.TransitionName = "T_u2";
		t3.InputPlaceName.add("P_a2");
		t3.InputPlaceName.add("car2");

		Condition T3Ct1 = new Condition(t3, "P_a2", TransitionCondition.NotNull);
		Condition T3Ct2 = new Condition(t1, "P_x2", TransitionCondition.CanAddCars);
		T3Ct1.SetNextCondition(LogicConnector.AND, T3Ct2);

		GuardMapping grdT3 = new GuardMapping();
		grdT3.condition = T3Ct1;
		grdT3.Activations.add(new Activation(t1, "car2", TransitionOperation.AddElement, "SENSOR2C"));
		grdT3.Activations.add(new Activation(t1, "car2", TransitionOperation.AddElement, "car2"));
		grdT3.Activations.add(new Activation(t3, "P_a2", TransitionOperation.AddElement, "P_x2"));
		t3.GuardMappingList.add(grdT3);

		t3.Delay = 0;
		pn.Transitions.add(t3);

		// T4 ------------------------------------------------
		PetriTransition t4 = new PetriTransition(pn);
		t4.TransitionName = "T_e2";
		t4.InputPlaceName.add("P_x2");
		t4.InputPlaceName.add("P_TL2");

		Condition T4Ct1 = new Condition(t4, "P_TL2", TransitionCondition.Equal, "green");
		Condition T4Ct2 = new Condition(t4, "P_x2", TransitionCondition.HaveCar);
		T4Ct1.SetNextCondition(LogicConnector.AND, T4Ct2);

		GuardMapping grdT4 = new GuardMapping();
		grdT4.condition = T4Ct1;
		grdT4.Activations.add(new Activation(t4, "P_x2", TransitionOperation.PopElementWithoutTarget, "P_b2"));
		grdT4.Activations.add(new Activation(t4, "P_TL2", TransitionOperation.Move, "P_TL2"));
		t4.GuardMappingList.add(grdT2);

		t4.Delay = 0;
		pn.Transitions.add(t4);

		// T5 ------------------------------------------------
		PetriTransition t5 = new PetriTransition(pn);
		t5.TransitionName = "T_u3";
		t5.InputPlaceName.add("P_a3");
		t5.InputPlaceName.add("car3");

		Condition T5Ct1 = new Condition(t5, "P_a3", TransitionCondition.NotNull);
		Condition T5Ct2 = new Condition(t5, "P_x3", TransitionCondition.CanAddCars);
		T5Ct1.SetNextCondition(LogicConnector.AND, T5Ct2);

		GuardMapping grdT5 = new GuardMapping();
		grdT5.condition = T5Ct1;
		grdT5.Activations.add(new Activation(t1, "car3", TransitionOperation.AddElement, "SENSOR3C"));
		grdT5.Activations.add(new Activation(t1, "car3", TransitionOperation.AddElement, "car3"));
		grdT5.Activations.add(new Activation(t5, "P_a3", TransitionOperation.AddElement, "P_x3"));
		t5.GuardMappingList.add(grdT5);

		t5.Delay = 0;
		pn.Transitions.add(t5);

		// T6 ------------------------------------------------
		PetriTransition t6 = new PetriTransition(pn);
		t6.TransitionName = "T_e3";
		t6.InputPlaceName.add("P_x3");
		t6.InputPlaceName.add("P_TL3");

		Condition T6Ct1 = new Condition(t6, "P_TL3", TransitionCondition.Equal, "green");
		Condition T6Ct2 = new Condition(t6, "P_x3", TransitionCondition.HaveCar);
		T6Ct1.SetNextCondition(LogicConnector.AND, T6Ct2);

		GuardMapping grdT6 = new GuardMapping();
		grdT6.condition = T6Ct1;
		grdT6.Activations.add(new Activation(t6, "P_x3", TransitionOperation.PopElementWithoutTarget, "P_b3"));
		grdT6.Activations.add(new Activation(t6, "P_TL3", TransitionOperation.Move, "P_TL3"));
		t6.GuardMappingList.add(grdT6);

		t6.Delay = 0;
		pn.Transitions.add(t6);

		// T7 ------------------------------------------------
//		PetriTransition t7 = new PetriTransition(pn);
//		t7.TransitionName = "T_u4";
//		t7.InputPlaceName.add("P_a4");
//
//		Condition T7Ct1 = new Condition(t7, "P_a4", TransitionCondition.NotNull);
//		Condition T7Ct2 = new Condition(t5, "P_x4", TransitionCondition.CanAddCars);
//		T7Ct1.SetNextCondition(LogicConnector.AND, T7Ct2);
//
//		GuardMapping grdT7 = new GuardMapping();
//		grdT7.condition = T7Ct1;
//		grdT7.Activations.add(new Activation(t7, "P_a4", TransitionOperation.AddElement, "P_x4"));
//		t7.GuardMappingList.add(grdT7);
//
//		t7.Delay = 0;
//		pn.Transitions.add(t7);

		// T8 ------------------------------------------------
		PetriTransition t8 = new PetriTransition(pn);
		t8.TransitionName = "T_e5";
		t8.InputPlaceName.add("P_x5");
		t8.InputPlaceName.add("P_TL5");

		Condition T8Ct1 = new Condition(t8, "P_TL5", TransitionCondition.Equal, "green");
		Condition T8Ct2 = new Condition(t8, "P_x5", TransitionCondition.HaveCar);
		T8Ct1.SetNextCondition(LogicConnector.AND, T8Ct2);

		GuardMapping grdT8 = new GuardMapping();
		grdT8.condition = T8Ct1;
		grdT8.Activations.add(new Activation(t8, "P_x5", TransitionOperation.PopElementWithoutTarget, "P_b5"));
		grdT8.Activations.add(new Activation(t8, "P_TL5", TransitionOperation.Move, "P_TL5"));
		t8.GuardMappingList.add(grdT8);

		t8.Delay = 0;
		pn.Transitions.add(t8);

		// T9----------------------------------------------------------------

		PetriTransition t9 = new PetriTransition(pn);
		t9.TransitionName = "T_g1Exit";
		t9.InputPlaceName.add("P_o1");

		Condition T9Ct1 = new Condition(t9, "P_o1", TransitionCondition.HaveCar);

		GuardMapping grdT9 = new GuardMapping();
		grdT9.condition = T9Ct1;
		grdT9.Activations.add(new Activation(t9, "P_o1", TransitionOperation.PopElementWithoutTarget, "P_o1Exit"));
		t9.GuardMappingList.add(grdT9);

		t9.Delay = 0;
		pn.Transitions.add(t9);

		// T10----------------------------------------------------------------

		PetriTransition t10 = new PetriTransition(pn);
		t10.TransitionName = "T_g2Exit";
		t10.InputPlaceName.add("P_o2");

		Condition T10Ct1 = new Condition(t10, "P_o2", TransitionCondition.HaveCar);

		GuardMapping grdT10 = new GuardMapping();
		grdT10.condition = T10Ct1;
		grdT10.Activations.add(new Activation(t10, "P_o2", TransitionOperation.PopElementWithoutTarget, "P_o2Exit"));
		t10.GuardMappingList.add(grdT10);

		t10.Delay = 0;
		pn.Transitions.add(t10);

		// T11----------------------------------------------------------------

		PetriTransition t11 = new PetriTransition(pn);
		t11.TransitionName = "T_g3Exit";
		t11.InputPlaceName.add("P_o3");

		Condition T11Ct1 = new Condition(t11, "P_o3", TransitionCondition.HaveCar);

		GuardMapping grdT11 = new GuardMapping();
		grdT11.condition = T11Ct1;
		grdT11.Activations.add(new Activation(t11, "P_o3", TransitionOperation.PopElementWithoutTarget, "P_o3Exit"));
		t11.GuardMappingList.add(grdT11);

		t11.Delay = 0;
		pn.Transitions.add(t11);

		// T12----------------------------------------------------------------
//
//		PetriTransition t12 = new PetriTransition(pn);
//		t12.TransitionName = "T_g4Exit";
//		t12.InputPlaceName.add("P_o4");
//
//		Condition T12Ct1 = new Condition(t12, "P_o4", TransitionCondition.HaveCar);
//
//		GuardMapping grdT12 = new GuardMapping();
//		grdT12.condition = T12Ct1;
//		grdT12.Activations.add(new Activation(t12, "P_o4", TransitionOperation.PopElementWithoutTarget, "P_o4Exit"));
//		t12.GuardMappingList.add(grdT12);
//
//		t12.Delay = 0;
//		pn.Transitions.add(t12);

		// --------------------------------------first part-------------------------------------------

		// T13 ------------------------------------------------
		PetriTransition t13 = new PetriTransition(pn);
		t13.TransitionName = "P_IR";
		t13.InputPlaceName.add("P_b1");

		Condition T13Ct1 = new Condition(t13, "P_b1", TransitionCondition.NotNull);
		Condition T13Ct2 = new Condition(t13, "P_IR", TransitionCondition.CanAddCars);
		T13Ct1.SetNextCondition(LogicConnector.AND, T13Ct2);

		GuardMapping grdT13 = new GuardMapping();
		grdT13.condition = T13Ct1;
		grdT13.Activations.add(new Activation(t13, "P_b1", TransitionOperation.AddElement, "P_IR"));
		t13.GuardMappingList.add(grdT13);

		t13.Delay = 0;
		pn.Transitions.add(t13);

		// T14-----------------------------------------------------------
		PetriTransition t14 = new PetriTransition(pn);
		t14.TransitionName = "T_g1";
		t14.InputPlaceName.add("P_IR");

		Condition T14Ct1 = new Condition(t14, "P_IR", TransitionCondition.HaveCarForMe);

		GuardMapping grdT14 = new GuardMapping();
		grdT14.condition = T14Ct1;
		grdT14.Activations.add(new Activation(t14, "P_IR", TransitionOperation.PopElementWithTargetToQueue, "P_o1"));
		t14.GuardMappingList.add(grdT14);

		t14.Delay = 0;
		pn.Transitions.add(t14);

		// ---------------------------------Second Part-------------------------------------------

		// T15 ------------------------------------------------
		PetriTransition t15 = new PetriTransition(pn);
		t15.TransitionName = "T_i2";
		t15.InputPlaceName.add("P_b2");

		Condition T15Ct1 = new Condition(t15, "P_b2", TransitionCondition.NotNull);
		Condition T15Ct2 = new Condition(t15, "P_IR", TransitionCondition.CanAddCars);
		T15Ct1.SetNextCondition(LogicConnector.AND, T15Ct2);

		GuardMapping grdT15 = new GuardMapping();
		grdT15.condition = T15Ct1;
		grdT15.Activations.add(new Activation(t15, "P_b2", TransitionOperation.AddElement, "P_IR"));
		t15.GuardMappingList.add(grdT15);

		t15.Delay = 0;
		pn.Transitions.add(t15);

		// T16-----------------------------------------------------------
		PetriTransition t16 = new PetriTransition(pn);
		t16.TransitionName = "T_g2";
		t16.InputPlaceName.add("P_IR");

		Condition T16Ct1 = new Condition(t16, "P_IR", TransitionCondition.HaveCarForMe);

		GuardMapping grdT16 = new GuardMapping();
		grdT16.condition = T16Ct1;
		grdT16.Activations.add(new Activation(t16, "P_IR", TransitionOperation.PopElementWithTargetToQueue, "P_o2"));
		t16.GuardMappingList.add(grdT16);

		t16.Delay = 0;
		pn.Transitions.add(t16);

		// ----------------------Third Part----------------------------------------------------------------

		// T17 ------------------------------------------------
		PetriTransition t17 = new PetriTransition(pn);
		t17.TransitionName = "T_i3";
		t11.InputPlaceName.add("P_b3");

		Condition T17Ct1 = new Condition(t11, "P_b3", TransitionCondition.NotNull);
		Condition T17Ct2 = new Condition(t11, "P_IR", TransitionCondition.CanAddCars);
		T17Ct1.SetNextCondition(LogicConnector.AND, T17Ct2);

		GuardMapping grdT17 = new GuardMapping();
		grdT17.condition = T17Ct1;
		grdT17.Activations.add(new Activation(t17, "P_b3", TransitionOperation.AddElement, "P_IR"));
		t17.GuardMappingList.add(grdT17);

		t17.Delay = 0;
		pn.Transitions.add(t17);

		// T18---------------------------------------------------------

		PetriTransition t18 = new PetriTransition(pn);
		t18.TransitionName = "T_g3";
		t18.InputPlaceName.add("P_IR");

		Condition T18Ct1 = new Condition(t18, "P_IR", TransitionCondition.HaveCarForMe);

		GuardMapping grdT18 = new GuardMapping();
		grdT18.condition = T18Ct1;
		grdT18.Activations.add(new Activation(t18, "P_IR", TransitionOperation.PopElementWithTargetToQueue, "P_o3"));
		t18.GuardMappingList.add(grdT18);

		t18.Delay = 0;
		pn.Transitions.add(t18);

		// -------------------------------------Fourth Part------------------------------------------

		// T19 ------------------------------------------------
		PetriTransition t19 = new PetriTransition(pn);
		t19.TransitionName = "T_i4";
		t19.InputPlaceName.add("P_b4");

		Condition T19Ct1 = new Condition(t19, "P_b4", TransitionCondition.NotNull);
		Condition T19Ct2 = new Condition(t19, "P_IR", TransitionCondition.CanAddCars);
		T19Ct1.SetNextCondition(LogicConnector.AND, T19Ct2);

		GuardMapping grdT19 = new GuardMapping();
		grdT19.condition = T19Ct1;
		grdT19.Activations.add(new Activation(t19, "P_b4", TransitionOperation.PopElementWithoutTarget, "P_IR"));
		t19.GuardMappingList.add(grdT19);

		t19.Delay = 0;
		pn.Transitions.add(t19);

		// T20---------------------------------------------------------

		PetriTransition t20 = new PetriTransition(pn);
		t20.TransitionName = "T_g4";
		t20.InputPlaceName.add("P_IL");

		Condition T20Ct1 = new Condition(t20, "P_IL", TransitionCondition.HaveCarForMe);

		GuardMapping grdT20 = new GuardMapping();
		grdT20.condition = T20Ct1;
		grdT20.Activations.add(new Activation(t20, "P_IL", TransitionOperation.PopElementWithTargetToQueue, "P_x4"));
		t20.GuardMappingList.add(grdT20);

		t20.Delay = 0;
		pn.Transitions.add(t20);
		
		// T21 WARNING------------------------------------------------
//		PetriTransition t21 = new PetriTransition(pn);
//		t21.TransitionName = "T_u4";
//		t21.InputPlaceName.add("P_a1");
//
//		Condition T21Ct1 = new Condition(t21, "P_a1", TransitionCondition.NotNull);
//		Condition T21Ct2 = new Condition(t21, "P_x1", TransitionCondition.CanAddCars);
//		T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);
//
//		GuardMapping grdT1 = new GuardMapping();
//		grdT1.condition = T1Ct1;
//		grdT1.Activations.add(new Activation(t1, "P_a1", TransitionOperation.AddElement, "P_x1"));
//		t1.GuardMappingList.add(grdT1);
//
//		t21.Delay = 0;
//		pn.Transitions.add(t1);

		// T22 ------------------------------------------------
		PetriTransition t22 = new PetriTransition(pn);
		t2.TransitionName = "T_e4";
		t2.InputPlaceName.add("P_x4");
		t2.InputPlaceName.add("P_TL4");

		Condition T22Ct1 = new Condition(t2, "P_TL4", TransitionCondition.Equal, "green");
		Condition T22Ct2 = new Condition(t2, "P_x4", TransitionCondition.HaveCar);
		T22Ct1.SetNextCondition(LogicConnector.AND, T22Ct2);

		GuardMapping grdT22 = new GuardMapping();
		grdT22.condition = T22Ct1;
		grdT22.Activations.add(new Activation(t22, "P_x4", TransitionOperation.PopElementWithoutTarget, "P_b4"));
	    grdT22.Activations.add(new Activation(t22, "P_TL4", TransitionOperation.Move, "P_TL4"));
	    
		t22.GuardMappingList.add(grdT22);

//				t22.Delay = 3; TODO
		pn.Transitions.add(t22);
		
		// T23 WARNING------------------------------------------------
//		PetriTransition t21 = new PetriTransition(pn);
//		t21.TransitionName = "T_u4";
//		t21.InputPlaceName.add("P_a1");
//
//		Condition T21Ct1 = new Condition(t21, "P_a1", TransitionCondition.NotNull);
//		Condition T21Ct2 = new Condition(t21, "P_x1", TransitionCondition.CanAddCars);
//		T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);
//
//		GuardMapping grdT1 = new GuardMapping();
//		grdT1.condition = T1Ct1;
//		grdT1.Activations.add(new Activation(t1, "P_a1", TransitionOperation.AddElement, "P_x1"));
//		t1.GuardMappingList.add(grdT1);
//
//		t21.Delay = 0;
//		pn.Transitions.add(t1);

		// T24 ------------------------------------------------
		PetriTransition t24 = new PetriTransition(pn);
		t2.TransitionName = "T_e5";
		t2.InputPlaceName.add("P_x5");
		t2.InputPlaceName.add("P_TL5");

		Condition T24Ct1 = new Condition(t24, "P_TL5", TransitionCondition.Equal, "green");
		Condition T24Ct2 = new Condition(t22, "P_x5", TransitionCondition.HaveCar);
		T24Ct1.SetNextCondition(LogicConnector.AND, T24Ct2);

		GuardMapping grdT24 = new GuardMapping();
		grdT24.condition = T24Ct1;
		grdT24.Activations.add(new Activation(t24, "P_x5", TransitionOperation.PopElementWithoutTarget, "P_b5"));
	    grdT24.Activations.add(new Activation(t24, "P_TL5", TransitionOperation.Move, "P_TL5"));
	    
		t24.GuardMappingList.add(grdT24);

//				t24.Delay = 3; TODO
		pn.Transitions.add(t24);
		
		
		// T25 ------------------------------------------------
		PetriTransition t25 = new PetriTransition(pn);
		t25.TransitionName = "T_u6";
		t25.InputPlaceName.add("P_a6");
		t25.InputPlaceName.add("car6");

		Condition T25Ct1 = new Condition(t25, "P_a6", TransitionCondition.NotNull);
		Condition T25Ct2 = new Condition(t25, "P_x6", TransitionCondition.CanAddCars);
		T25Ct1.SetNextCondition(LogicConnector.AND, T25Ct2);

		GuardMapping grdT25 = new GuardMapping();
		grdT25.condition = T25Ct1;
		grdT25.Activations.add(new Activation(t1, "car6", TransitionOperation.AddElement, "SENSOR6C"));
		grdT25.Activations.add(new Activation(t1, "car6", TransitionOperation.AddElement, "car6"));
		grdT25.Activations.add(new Activation(t25, "P_a6", TransitionOperation.AddElement, "P_x6"));
		t25.GuardMappingList.add(grdT25);

		t25.Delay = 0;
		pn.Transitions.add(t25);

		// T26 ------------------------------------------------
		PetriTransition t26 = new PetriTransition(pn);
		t26.TransitionName = "T_e6";
		t26.InputPlaceName.add("P_x6");
		t26.InputPlaceName.add("P_TL6");

		Condition T26Ct1 = new Condition(t26, "P_TL6", TransitionCondition.Equal, "green");
		Condition T26Ct2 = new Condition(t26, "P_x6", TransitionCondition.HaveCar);
		T26Ct1.SetNextCondition(LogicConnector.AND, T26Ct2);

		GuardMapping grdT26 = new GuardMapping();
		grdT26.condition = T26Ct1;
		grdT26.Activations.add(new Activation(t26, "P_x6", TransitionOperation.PopElementWithoutTarget, "P_b6"));
	    grdT26.Activations.add(new Activation(t26, "P_TL6", TransitionOperation.Move, "P_TL6"));
	    
		t26.GuardMappingList.add(grdT26);

//				t26.Delay = 3; TODO
		pn.Transitions.add(t26);
		
		// T27 ------------------------------------------------
		PetriTransition t27 = new PetriTransition(pn);
		t27.TransitionName = "T_u7";
		t27.InputPlaceName.add("P_a7");
		t27.InputPlaceName.add("car7");

		Condition T27Ct1 = new Condition(t27, "P_a7", TransitionCondition.NotNull);
		Condition T27Ct2 = new Condition(t27, "P_x7", TransitionCondition.CanAddCars);
		T25Ct1.SetNextCondition(LogicConnector.AND, T27Ct2);

		GuardMapping grdT27 = new GuardMapping();
		grdT27.condition = T27Ct1;
		grdT27.Activations.add(new Activation(t1, "car7", TransitionOperation.AddElement, "SENSOR7C"));
		grdT27.Activations.add(new Activation(t1, "car7", TransitionOperation.AddElement, "car7"));
		grdT27.Activations.add(new Activation(t27, "P_a7", TransitionOperation.AddElement, "P_x7"));
		t27.GuardMappingList.add(grdT27);

		t27.Delay = 0;
		pn.Transitions.add(t27);

		// T28 ------------------------------------------------
		PetriTransition t28 = new PetriTransition(pn);
		t28.TransitionName = "T_e7";
		t28.InputPlaceName.add("P_x7");
		t28.InputPlaceName.add("P_TL7");

		Condition T28Ct1 = new Condition(t26, "P_TL7", TransitionCondition.Equal, "green");
		Condition T28Ct2 = new Condition(t26, "P_x7", TransitionCondition.HaveCar);
		T26Ct1.SetNextCondition(LogicConnector.AND, T28Ct2);

		GuardMapping grdT28 = new GuardMapping();
		grdT28.condition = T28Ct1;
		grdT28.Activations.add(new Activation(t28, "P_x7", TransitionOperation.PopElementWithoutTarget, "P_b7"));
	    grdT28.Activations.add(new Activation(t28, "P_TL7", TransitionOperation.Move, "P_TL7"));
	    
		t28.GuardMappingList.add(grdT28);

//		t28.Delay = 3; TODO
		pn.Transitions.add(t28);
		
		// T29----------------------------------------------------------------

		PetriTransition t29 = new PetriTransition(pn);
		t29.TransitionName = "T_g6Exit";
		t29.InputPlaceName.add("P_o6");

		Condition T29Ct1 = new Condition(t29, "P_o6", TransitionCondition.HaveCar);

		GuardMapping grdT29 = new GuardMapping();
		grdT29.condition = T29Ct1;
		grdT29.Activations.add(new Activation(t29, "P_o6", TransitionOperation.PopElementWithoutTarget, "P_o6Exit"));
		t29.GuardMappingList.add(grdT29);

		t29.Delay = 0;
		pn.Transitions.add(t29);
		
		// T30----------------------------------------------------------------

		PetriTransition t30 = new PetriTransition(pn);
		t30.TransitionName = "T_g7Exit";
		t30.InputPlaceName.add("P_o7");
		
		Condition T30Ct1 = new Condition(t30, "P_o7", TransitionCondition.HaveCar);

		GuardMapping grdT30 = new GuardMapping();
		grdT30.condition = T30Ct1;
		grdT30.Activations.add(new Activation(t30, "P_o7", TransitionOperation.PopElementWithoutTarget, "P_o7Exit"));
		t30.GuardMappingList.add(grdT30);

		t30.Delay = 0;
		pn.Transitions.add(t30);
		
		// T31 ------------------------------------------------
		PetriTransition t31 = new PetriTransition(pn);
		t31.TransitionName = "T_i6";
		t31.InputPlaceName.add("P_b6");

		Condition T31Ct1 = new Condition(t31, "P_b6", TransitionCondition.NotNull);
		Condition T31Ct2 = new Condition(t31, "P_IL", TransitionCondition.CanAddCars);
		T31Ct1.SetNextCondition(LogicConnector.AND, T31Ct2);

		GuardMapping grdT31 = new GuardMapping();
		grdT31.condition = T31Ct1;
		grdT31.Activations.add(new Activation(t31, "P_b6", TransitionOperation.AddElement, "P_IL"));
		t31.GuardMappingList.add(grdT31);

		t31.Delay = 0;
		pn.Transitions.add(t31);

		// T32-----------------------------------------------------------
		PetriTransition t32 = new PetriTransition(pn);
		t32.TransitionName = "T_g6";
		t32.InputPlaceName.add("P_IL");

		Condition T32Ct1 = new Condition(t32, "P_IL", TransitionCondition.HaveCarForMe);

		GuardMapping grdT32 = new GuardMapping();
		grdT32.condition = T32Ct1;
		grdT32.Activations.add(new Activation(t32, "P_IL", TransitionOperation.PopElementWithTargetToQueue, "P_o6"));
		t32.GuardMappingList.add(grdT32);

		t32.Delay = 0;
		pn.Transitions.add(t32);
		
		// T33 ------------------------------------------------
		PetriTransition t33 = new PetriTransition(pn);
		t33.TransitionName = "T_i7";
		t33.InputPlaceName.add("P_b7");

		Condition T33Ct1 = new Condition(t33, "P_b7", TransitionCondition.NotNull);
		Condition T33Ct2 = new Condition(t33, "P_IL", TransitionCondition.CanAddCars);
		T33Ct1.SetNextCondition(LogicConnector.AND, T33Ct2);

		GuardMapping grdT33 = new GuardMapping();
		grdT33.condition = T33Ct1;
		grdT33.Activations.add(new Activation(t33, "P_b7", TransitionOperation.AddElement, "P_IL"));
		t33.GuardMappingList.add(grdT33);

		t33.Delay = 0;
		pn.Transitions.add(t33);

		// T34-----------------------------------------------------------
		PetriTransition t34 = new PetriTransition(pn);
		t34.TransitionName = "T_g7";
		t34.InputPlaceName.add("P_IL");

		Condition T34Ct1 = new Condition(t34, "P_IL", TransitionCondition.HaveCarForMe);

		GuardMapping grdT34 = new GuardMapping();
		grdT34.condition = T34Ct1;
		grdT34.Activations.add(new Activation(t34, "P_IL", TransitionOperation.PopElementWithTargetToQueue, "P_o7"));
		t34.GuardMappingList.add(grdT34);

		t34.Delay = 0;
		pn.Transitions.add(t34);
		
		// T35 ------------------------------------------------
		PetriTransition t35 = new PetriTransition(pn);
		t35.TransitionName = "T_i5";
		t35.InputPlaceName.add("P_b5");

		Condition T35Ct1 = new Condition(t35, "P_b5", TransitionCondition.NotNull);
		Condition T35Ct2 = new Condition(t35, "P_IL", TransitionCondition.CanAddCars);
		T35Ct1.SetNextCondition(LogicConnector.AND, T35Ct2);

		GuardMapping grdT35 = new GuardMapping();
		grdT35.condition = T35Ct1;
		grdT35.Activations.add(new Activation(t35, "P_b5", TransitionOperation.AddElement, "P_IL"));
		t35.GuardMappingList.add(grdT35);

		t35.Delay = 0;
		pn.Transitions.add(t35);

		// T36-----------------------------------------------------------
		PetriTransition t36 = new PetriTransition(pn);
		t36.TransitionName = "T_g5";
		t36.InputPlaceName.add("P_IR");

		Condition T36Ct1 = new Condition(t36, "P_IR", TransitionCondition.HaveCarForMe);

		GuardMapping grdT36 = new GuardMapping();
		grdT36.condition = T36Ct1;
		grdT36.Activations.add(new Activation(t36, "P_IR", TransitionOperation.PopElementWithTargetToQueue, "P_x5"));
		t36.GuardMappingList.add(grdT36);

		t36.Delay = 0;
		pn.Transitions.add(t36);
		
		// -------------------------------------------------------------------------------------
		// ----------------------------PN Start-------------------------------------------------
		// -------------------------------------------------------------------------------------

		System.out.println("Exp1 started \n ------------------------------");
		pn.Delay = 2000;
		// pn.Start();
		
		// How do I pass this to the intersection
//		ArrayList<String> traseu = new ArrayList<>();
//		traseu.add("T_g5");
//		traseu.add("T_g7");
//		Car car1 = new Car("BWM", "AB80", traseu);

		PetriNetWindow frame = new PetriNetWindow();
		frame.petriNet = pn;
		frame.setVisible(true);
	}
}
