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

public class Controller3F {
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
		p1.SetName("r1r2r3");
		p1.SetValue("signal");
		pn.PlaceList.add(p1);
		
		// Traffic light 1 cycle
		DataString p2 = new DataString();
		p2.SetName("g1r2r3");
		pn.PlaceList.add(p2);
		
		DataString p3 = new DataString();
		p3.SetName("y1r2r3");
		pn.PlaceList.add(p3);
		
		// Traffic light 2 cycle
		DataString p4 = new DataString();
		p4.SetName("r1g2r3");
		pn.PlaceList.add(p4);
		
		DataString p5 = new DataString();
		p5.SetName("r1y2r3");
		pn.PlaceList.add(p5);
		
		// Traffic light 3 cycle
		DataString p6 = new DataString();
		p6.SetName("r1r2g3");
		pn.PlaceList.add(p6);
		
		DataString p7 = new DataString();
		p7.SetName("r1r2y3");
		pn.PlaceList.add(p7);
		
		DataString pr1 = new DataString();
		pr1.SetName("allred_1");
		pn.PlaceList.add(pr1);
		
		DataString pr2 = new DataString();
		pr1.SetName("allred_2");
		pn.PlaceList.add(pr2);
		
		DataTransfer p8 = new DataTransfer();
		p8.SetName("OP5");
		p8.Value = new TransferOperation("localhost", "1082" , "P_TL5");
		pn.PlaceList.add(p8);
		
		DataTransfer p9 = new DataTransfer();
		p9.SetName("OP6");
		p9.Value = new TransferOperation("localhost", "1082" , "P_TL6");
		pn.PlaceList.add(p9);
		
		DataTransfer p10 = new DataTransfer();
		p10.SetName("OP7");
		p10.Value = new TransferOperation("localhost", "1082" , "P_TL7");
		pn.PlaceList.add(p10);
		
		
		//----------------------------iniT------------------------------------
		PetriTransition iniT = new PetriTransition(pn);
		iniT.TransitionName = "iniT";
		iniT.InputPlaceName.add("ini");
		
		Condition iniTCt1 = new Condition(iniT, "ini", TransitionCondition.NotNull);

		GuardMapping grdiniT = new GuardMapping();
		grdiniT.condition= iniTCt1;
		
		grdiniT.Activations.add(new Activation(iniT, "ini", TransitionOperation.SendOverNetwork, "OP5"));
		grdiniT.Activations.add(new Activation(iniT, "ini", TransitionOperation.SendOverNetwork, "OP6"));
		grdiniT.Activations.add(new Activation(iniT, "ini", TransitionOperation.SendOverNetwork, "OP7"));		
		iniT.GuardMappingList.add(grdiniT);
	
		iniT.Delay = 5;
		pn.Transitions.add(iniT);
		
		
        // Transition T1  
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "T1";
        t1.InputPlaceName.add("r1r2r3");
        t1.InputPlaceName.add("green");
        
        Condition T1CttransIndex = new Condition(t1, "r1r2r3", TransitionCondition.NotNull);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition= T1CttransIndex;
        grdT1.Activations.add(new Activation(t1, "r1r2r3", TransitionOperation.Move, "g1r2r3"));
        grdT1.Activations.add(new Activation(t1, "green", TransitionOperation.SendOverNetwork, "OP5"));
        grdT1.Activations.add(new Activation(t1, "green", TransitionOperation.Move, "green"));
                
        t1.GuardMappingList.add(grdT1);
    
        t1.Delay = 5;
        pn.Transitions.add(t1);
        
            
        // Transition T2  
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "T2";
        t2.InputPlaceName.add("g1r2r3");
        t2.InputPlaceName.add("yellow");
        
        Condition T2CttransIndex = new Condition(t2, "g1r2r3", TransitionCondition.NotNull);

        GuardMapping grdT2 = new GuardMapping();
        grdT2.condition= T2CttransIndex;
        grdT2.Activations.add(new Activation(t2, "g1r2r3", TransitionOperation.Move, "y1r2r3"));
        grdT2.Activations.add(new Activation(t2, "yellow", TransitionOperation.SendOverNetwork, "OP5"));
        grdT2.Activations.add(new Activation(t2, "yellow", TransitionOperation.Move, "yellow"));
                
        t2.GuardMappingList.add(grdT2);
    
        t2.Delay = 5;
        pn.Transitions.add(t2);
        
            
        // Transition T3  
        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "T3";
        t3.InputPlaceName.add("y1r2r3");
        t3.InputPlaceName.add("red");
        
        Condition T3CttransIndex = new Condition(t3, "y1r2r3", TransitionCondition.NotNull);

        GuardMapping grdT3 = new GuardMapping();
        grdT3.condition= T3CttransIndex;
        grdT3.Activations.add(new Activation(t3, "y1r2r3", TransitionOperation.Move, "allred_1"));
        grdT3.Activations.add(new Activation(t3, "red", TransitionOperation.SendOverNetwork, "OP5"));
        grdT3.Activations.add(new Activation(t3, "red", TransitionOperation.Move, "red"));
                
        t3.GuardMappingList.add(grdT3);
    
        t3.Delay = 5;
        pn.Transitions.add(t3);
        
            
        // Transition T4  
        PetriTransition t4 = new PetriTransition(pn);
        t4.TransitionName = "T4";
        t4.InputPlaceName.add("allred_1");
        t4.InputPlaceName.add("green");
        
        Condition T4CttransIndex = new Condition(t4, "allred_1", TransitionCondition.NotNull);

        GuardMapping grdT4 = new GuardMapping();
        grdT4.condition= T4CttransIndex;
        grdT4.Activations.add(new Activation(t4, "allred_1", TransitionOperation.Move, "r1g2r3"));
        grdT4.Activations.add(new Activation(t4, "green", TransitionOperation.SendOverNetwork, "OP6"));
        grdT4.Activations.add(new Activation(t4, "green", TransitionOperation.Move, "green"));
                
        t4.GuardMappingList.add(grdT4);
    
        t4.Delay = 5;
        pn.Transitions.add(t4);
        
            
        // Transition T5  
        PetriTransition t5 = new PetriTransition(pn);
        t5.TransitionName = "T5";
        t5.InputPlaceName.add("r1g2r3");
        t5.InputPlaceName.add("yellow");
        
        Condition T5CttransIndex = new Condition(t5, "r1g2r3", TransitionCondition.NotNull);

        GuardMapping grdT5 = new GuardMapping();
        grdT5.condition= T5CttransIndex;
        grdT5.Activations.add(new Activation(t5, "r1g2r3", TransitionOperation.Move, "r1y2r3"));
        grdT5.Activations.add(new Activation(t5, "yellow", TransitionOperation.SendOverNetwork, "OP6"));
        grdT5.Activations.add(new Activation(t5, "yellow", TransitionOperation.Move, "yellow"));
                
        t5.GuardMappingList.add(grdT5);
    
        t5.Delay = 5;
        pn.Transitions.add(t5);
        
            
        // Transition T6  
        PetriTransition t6 = new PetriTransition(pn);
        t6.TransitionName = "T6";
        t6.InputPlaceName.add("r1y2r3");
        t6.InputPlaceName.add("red");
        
        Condition T6CttransIndex = new Condition(t6, "r1y2r3", TransitionCondition.NotNull);

        GuardMapping grdT6 = new GuardMapping();
        grdT6.condition= T6CttransIndex;
        grdT6.Activations.add(new Activation(t6, "r1y2r3", TransitionOperation.Move, "allred_2"));
        grdT6.Activations.add(new Activation(t6, "red", TransitionOperation.SendOverNetwork, "OP6"));
        grdT6.Activations.add(new Activation(t6, "red", TransitionOperation.Move, "red"));
                
        t6.GuardMappingList.add(grdT6);
    
        t6.Delay = 5;
        pn.Transitions.add(t6);
        
            
        // Transition T7  
        PetriTransition t7 = new PetriTransition(pn);
        t7.TransitionName = "T7";
        t7.InputPlaceName.add("allred_2");
        t7.InputPlaceName.add("green");
        
        Condition T7CttransIndex = new Condition(t7, "allred_2", TransitionCondition.NotNull);

        GuardMapping grdT7 = new GuardMapping();
        grdT7.condition= T7CttransIndex;
        grdT7.Activations.add(new Activation(t7, "allred_2", TransitionOperation.Move, "r1r2g3"));
        grdT7.Activations.add(new Activation(t7, "green", TransitionOperation.SendOverNetwork, "OP7"));
        grdT7.Activations.add(new Activation(t7, "green", TransitionOperation.Move, "green"));
                
        t7.GuardMappingList.add(grdT7);
    
        t7.Delay = 5;
        pn.Transitions.add(t7);
        
            
        // Transition T8  
        PetriTransition t8 = new PetriTransition(pn);
        t8.TransitionName = "T8";
        t8.InputPlaceName.add("r1r2g3");
        t8.InputPlaceName.add("yellow");
        
        Condition T8CttransIndex = new Condition(t8, "r1r2g3", TransitionCondition.NotNull);

        GuardMapping grdT8 = new GuardMapping();
        grdT8.condition= T8CttransIndex;
        grdT8.Activations.add(new Activation(t8, "r1r2g3", TransitionOperation.Move, "r1r2y3"));
        grdT8.Activations.add(new Activation(t8, "yellow", TransitionOperation.SendOverNetwork, "OP7"));
        grdT8.Activations.add(new Activation(t8, "yellow", TransitionOperation.Move, "yellow"));
                
        t8.GuardMappingList.add(grdT8);
    
        t8.Delay = 5;
        pn.Transitions.add(t8);
        
            
        // Transition T9  
        PetriTransition t9 = new PetriTransition(pn);
        t9.TransitionName = "T9";
        t9.InputPlaceName.add("r1r2y3");
        t9.InputPlaceName.add("red");
        
        Condition T9CttransIndex = new Condition(t9, "r1r2y3", TransitionCondition.NotNull);

        GuardMapping grdT9 = new GuardMapping();
        grdT9.condition= T9CttransIndex;
        grdT9.Activations.add(new Activation(t9, "r1r2y3", TransitionOperation.Move, "r1r2r3"));
        grdT9.Activations.add(new Activation(t9, "red", TransitionOperation.SendOverNetwork, "OP7"));
        grdT9.Activations.add(new Activation(t9, "red", TransitionOperation.Move, "red"));
                
        t9.GuardMappingList.add(grdT9);
    
        t9.Delay = 5;
        pn.Transitions.add(t9);
        
        
		
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
