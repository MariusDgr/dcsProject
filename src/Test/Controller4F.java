package Test;

import Components.Activation;
import Components.Condition;
import Components.GuardMapping;
import Components.PetriNet;
import Components.PetriNetWindow;
import Components.PetriTransition;
import DataObjects.DataString;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Controller4F {
	public static void main (String []args) {
		PetriNet pn = new PetriNet();
		pn.PetriNetName = "Controller";
		pn.SetName("Controller");
		pn.NetworkPort = 1081;
		
		DataString ini = new DataString();
		//ini.Printable = false;
		ini.SetName("ini");
		ini.SetValue("red");
		pn.PlaceList.add(ini);
		
		DataString red = new DataString();
		//red.Printable = false;
		red.SetName("red");
		red.SetValue("red");
		pn.PlaceList.add(red);
		
		DataString green = new DataString();
		//green.Printable = false;
		green.SetName("green");
		green.SetValue("green");
		pn.PlaceList.add(green);
		
		DataString yellow = new DataString();
		//yellow.Printable = false;
		yellow.SetName("yellow");
		yellow.SetValue("yellow");
		pn.PlaceList.add(yellow);
		
		DataString p1 = new DataString();
		p1.SetName("r1r2r3r4");
		p1.SetValue("signal");
		pn.PlaceList.add(p1);
		
		// TL1
		DataString p2 = new DataString();
		p2.SetName("g1r2r3r4");
		pn.PlaceList.add(p2);
		
		DataString p3 = new DataString();
		p3.SetName("y1r2r3r4");
		pn.PlaceList.add(p3);
		
		DataString pr1 = new DataString();
		pr1.SetName("allred_1");
		pn.PlaceList.add(pr1);
		
		// TL2
		DataString p4 = new DataString();
		p4.SetName("r1g2r3r4");
		pn.PlaceList.add(p4);
		
		DataString p5 = new DataString();
		p5.SetName("r1y2r3r4");
		pn.PlaceList.add(p5);
		
		DataString pr2 = new DataString();
		pr2.SetName("allred_2");
		pn.PlaceList.add(pr2);
		
		// TL3
		DataString p6 = new DataString();
		p6.SetName("r1r2g3r4");
		pn.PlaceList.add(p6);
		
		DataString p7 = new DataString();
		p7.SetName("r1r2y3r4");
		pn.PlaceList.add(p7);
		
		DataString pr3 = new DataString();
		pr3.SetName("allred_3");
		pn.PlaceList.add(pr3);
		
		// TL4
		DataString p8 = new DataString();
		p8.SetName("r1r2r3g4");
		pn.PlaceList.add(p8);
		
		DataString p9 = new DataString();
		p9.SetName("r1r2r3y4");
		pn.PlaceList.add(p9);
		
		
		
		DataTransfer p10 = new DataTransfer();
		p10.SetName("OP1");
		p10.Value = new TransferOperation("localhost", "1080" , "P_TL1");
		pn.PlaceList.add(p10);
		
		DataTransfer p11 = new DataTransfer();
		p11.SetName("OP2");
		p11.Value = new TransferOperation("localhost", "1080" , "P_TL2");
		pn.PlaceList.add(p11);
		
		DataTransfer p12 = new DataTransfer();
		p12.SetName("OP3");
		p12.Value = new TransferOperation("localhost", "1080" , "P_TL3");
		pn.PlaceList.add(p12);
		
		DataTransfer p13 = new DataTransfer();
		p13.SetName("OP4");
		p13.Value = new TransferOperation("localhost", "1080" , "P_TL4");
		pn.PlaceList.add(p13);
		
		
		//----------------------------iniT------------------------------------
		PetriTransition iniT = new PetriTransition(pn);
		iniT.TransitionName = "iniT";
		iniT.InputPlaceName.add("ini");
		
		Condition iniTCt1 = new Condition(iniT, "ini", TransitionCondition.NotNull);

		GuardMapping grdiniT = new GuardMapping();
		grdiniT.condition= iniTCt1;
		
		grdiniT.Activations.add(new Activation(iniT, "ini", TransitionOperation.SendOverNetwork, "OP1"));
		grdiniT.Activations.add(new Activation(iniT, "ini", TransitionOperation.SendOverNetwork, "OP2"));
		grdiniT.Activations.add(new Activation(iniT, "ini", TransitionOperation.SendOverNetwork, "OP3"));
		grdiniT.Activations.add(new Activation(iniT, "ini", TransitionOperation.SendOverNetwork, "OP4"));
		
		iniT.GuardMappingList.add(grdiniT);
	
		iniT.Delay = 5;
		pn.Transitions.add(iniT);
		
		
		
		//----------------------------T1------------------------------------
		PetriTransition t1 = new PetriTransition(pn);
		t1.TransitionName = "T1";
		t1.InputPlaceName.add("r1r2r3r4");
		t1.InputPlaceName.add("green");
		
		
		Condition T1Ct1 = new Condition(t1, "r1r2", TransitionCondition.NotNull);

		GuardMapping grdT1 = new GuardMapping();
		grdT1.condition= T1Ct1;
		grdT1.Activations.add(new Activation(t1, "r1r2r3r4", TransitionOperation.Move, "g1r2r3r4"));
		grdT1.Activations.add(new Activation(t1, "green", TransitionOperation.SendOverNetwork, "OP1"));
		grdT1.Activations.add(new Activation(t1, "green", TransitionOperation.Move, "green"));
		t1.GuardMappingList.add(grdT1);
	
		t1.Delay = 5;
		pn.Transitions.add(t1);
		
		//----------------------------T2------------------------------------
		PetriTransition t2 = new PetriTransition(pn);
		t2.TransitionName = "T2";
		t2.InputPlaceName.add("g1r2r3r4");
		t2.InputPlaceName.add("yellow");
		
		
		Condition T2Ct1 = new Condition(t2, "g1r2r3r4", TransitionCondition.NotNull);

		GuardMapping grdT2 = new GuardMapping();
		grdT2.condition= T2Ct1;
		grdT2.Activations.add(new Activation(t2, "g1r2r3r4", TransitionOperation.Move, "y1r2r3r4"));
		grdT2.Activations.add(new Activation(t2, "yellow", TransitionOperation.SendOverNetwork, "OP1"));
		grdT2.Activations.add(new Activation(t2, "yellow", TransitionOperation.Move, "yellow"));
		
		t2.GuardMappingList.add(grdT2);
	
		t2.Delay = 5;
		pn.Transitions.add(t2);
		
		
		//----------------------------T3------------------------------------
		PetriTransition t3 = new PetriTransition(pn);
		t3.TransitionName = "T3";
		t3.InputPlaceName.add("y1r2r3r4");
		t3.InputPlaceName.add("red");
		
		Condition T3Ct1 = new Condition(t2, "y1r2", TransitionCondition.NotNull);

		GuardMapping grdT3 = new GuardMapping();
		grdT3.condition= T3Ct1;
		grdT3.Activations.add(new Activation(t3, "y1r2r3r4", TransitionOperation.Move, "allred_1"));
		grdT3.Activations.add(new Activation(t3, "red", TransitionOperation.SendOverNetwork, "OP1"));
		grdT3.Activations.add(new Activation(t3, "red", TransitionOperation.Move, "red"));
				
		t3.GuardMappingList.add(grdT3);
	
		t3.Delay = 5;
		pn.Transitions.add(t3);
		
		
		//----------------------------T3------------------------------------
		PetriTransition t4 = new PetriTransition(pn);
		t3.TransitionName = "T3";
		t3.InputPlaceName.add("y1r2r3r4");
		t3.InputPlaceName.add("red");
		
		Condition T3Ct1 = new Condition(t2, "y1r2", TransitionCondition.NotNull);

		GuardMapping grdT3 = new GuardMapping();
		grdT3.condition= T3Ct1;
		grdT3.Activations.add(new Activation(t3, "y1r2r3r4", TransitionOperation.Move, "allred_1"));
		grdT3.Activations.add(new Activation(t3, "red", TransitionOperation.SendOverNetwork, "OP1"));
		grdT3.Activations.add(new Activation(t3, "red", TransitionOperation.Move, "red"));
				
		t3.GuardMappingList.add(grdT3);
	
		t3.Delay = 5;
		pn.Transitions.add(t3);
		
		// -------------------------------------------------------------------------------------
		// ----------------------------PN Start-------------------------------------------------
		// -------------------------------------------------------------------------------------

		System.out.println("Exp1 started \n ------------------------------");
		pn.Delay = 2000;
		// pn.Start();

		PetriNetWindow frame = new PetriNetWindow();
		frame.petriNet = pn;
		frame.setVisible(true);
		
		
			
		
		
	}
}
