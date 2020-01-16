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
import Enumerations.LogicConnector;
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
		
		// --------------------- Adding sensors
		DataString psc1 = new DataString();
		psc1.SetName("SENSOR1C");
		pn.PlaceList.add(psc1);
		
		DataString psc2 = new DataString();
		psc2.SetName("SENSOR2C");
		pn.PlaceList.add(psc2);
		
		DataString psc3 = new DataString();
		psc3.SetName("SENSOR3C");
		pn.PlaceList.add(psc3);
		
//		DataString psc4 = new DataString();
//		psc4.SetName("SENSOR4C");
//		pn.PlaceList.add(psc4);
		
//		DataTransfer psc5 = new DataTransfer();
//		psc5.SetName("SENSOR5C");
//		psc5.Value = new TransferOperation("localhost", "1082", "SENSOR5C");
//		pn.PlaceList.add(psc5);
		
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
	
		iniT.Delay = 3;
		pn.Transitions.add(iniT);
		
		
	    
        // Transition T1  
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "T1";
        t1.InputPlaceName.add("r1r2r3r4");
        t1.InputPlaceName.add("green");
        t1.InputPlaceName.add("SENSOR1C");
        
        Condition T1CttransIndex = new Condition(t1, "r1r2r3r4", TransitionCondition.NotNull);
        Condition T1CttransIndex2 = new Condition(t1, "SENSOR1C", TransitionCondition.NotNull);
        T1CttransIndex.SetNextCondition(LogicConnector.AND, T1CttransIndex2);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition= T1CttransIndex;
        grdT1.Activations.add(new Activation(t1, "r1r2r3r4", TransitionOperation.Move, "g1r2r3r4"));
        grdT1.Activations.add(new Activation(t1, "green", TransitionOperation.SendOverNetwork, "OP1"));
        grdT1.Activations.add(new Activation(t1, "green", TransitionOperation.Move, "green"));
                
        t1.GuardMappingList.add(grdT1);
    
        t1.Delay = 1;
        pn.Transitions.add(t1);
        
     // Transition Tskip1  
        PetriTransition tskip1 = new PetriTransition(pn);
        tskip1.TransitionName = "Tskip1";
        tskip1.InputPlaceName.add("r1r2r3r4");
        tskip1.InputPlaceName.add("SENSOR1C");
        
        Condition T1CttransIndex_skip = new Condition(tskip1, "r1r2r3r4", TransitionCondition.NotNull);
        Condition T1CttransIndex2_skip = new Condition(tskip1, "SENSOR1C", TransitionCondition.IsNull);
        T1CttransIndex_skip.SetNextCondition(LogicConnector.AND, T1CttransIndex2_skip);

        GuardMapping grdT1_skip = new GuardMapping();
        grdT1_skip.condition= T1CttransIndex_skip;
        grdT1_skip.Activations.add(new Activation(tskip1, "r1r2r3r4", TransitionOperation.Move, "allred_1"));
                
        tskip1.GuardMappingList.add(grdT1_skip);
    
        tskip1.Delay = 0;
        pn.Transitions.add(tskip1);
        
            
        // Transition T2  
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "T2";
        t2.InputPlaceName.add("g1r2r3r4");
        t2.InputPlaceName.add("yellow");
        
        Condition T2CttransIndex = new Condition(t2, "g1r2r3r4", TransitionCondition.NotNull);

        GuardMapping grdT2 = new GuardMapping();
        grdT2.condition= T2CttransIndex;
        grdT2.Activations.add(new Activation(t2, "g1r2r3r4", TransitionOperation.Move, "y1r2r3r4"));
        grdT2.Activations.add(new Activation(t2, "yellow", TransitionOperation.SendOverNetwork, "OP1"));
        grdT2.Activations.add(new Activation(t2, "yellow", TransitionOperation.Move, "yellow"));
                
        t2.GuardMappingList.add(grdT2);
    
        t2.Delay = 5;
        pn.Transitions.add(t2);
        
            
        // Transition T3  
        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "T3";
        t3.InputPlaceName.add("y1r2r3r4");
        t3.InputPlaceName.add("red");
        
        Condition T3CttransIndex = new Condition(t3, "y1r2r3r4", TransitionCondition.NotNull);

        GuardMapping grdT3 = new GuardMapping();
        grdT3.condition= T3CttransIndex;
        grdT3.Activations.add(new Activation(t3, "y1r2r3r4", TransitionOperation.Move, "allred_1"));
        grdT3.Activations.add(new Activation(t3, "red", TransitionOperation.SendOverNetwork, "OP1"));
        grdT3.Activations.add(new Activation(t3, "red", TransitionOperation.Move, "red"));
                
        t3.GuardMappingList.add(grdT3);
    
        t3.Delay = 2;
        pn.Transitions.add(t3);
        
            
        // Transition T4  
        PetriTransition t4 = new PetriTransition(pn);
        t4.TransitionName = "T4";
        t4.InputPlaceName.add("allred_1");
        t4.InputPlaceName.add("green");
        t4.InputPlaceName.add("SENSOR2C");
        
        Condition T4CttransIndex = new Condition(t4, "allred_1", TransitionCondition.NotNull);
        Condition T4CttransIndex2 = new Condition(t4, "SENSOR2C", TransitionCondition.NotNull);
        T4CttransIndex.SetNextCondition(LogicConnector.AND, T4CttransIndex2);

        GuardMapping grdT4 = new GuardMapping();
        grdT4.condition= T4CttransIndex;
        grdT4.Activations.add(new Activation(t4, "allred_1", TransitionOperation.Move, "r1g2r3r4"));
        grdT4.Activations.add(new Activation(t4, "green", TransitionOperation.SendOverNetwork, "OP2"));
        grdT4.Activations.add(new Activation(t4, "green", TransitionOperation.Move, "green"));
                
        t4.GuardMappingList.add(grdT4);
    
        t4.Delay = 1;
        pn.Transitions.add(t4);
        
        // Transition Tskip Lane 2
        PetriTransition tskip2 = new PetriTransition(pn);
        tskip2.TransitionName = "Tskip2";
        tskip2.InputPlaceName.add("allred_1");
	    tskip2.InputPlaceName.add("SENSOR2C");
	    
	    Condition T4CttransIndex_skip = new Condition(tskip2, "allred_1", TransitionCondition.NotNull);
	    Condition T4CttransIndex2_skip = new Condition(tskip2, "SENSOR2C", TransitionCondition.IsNull);
	    T4CttransIndex_skip.SetNextCondition(LogicConnector.AND, T4CttransIndex2_skip);
	
	    GuardMapping grdT2_skip = new GuardMapping();
	    grdT2_skip.condition= T4CttransIndex_skip;
	    grdT2_skip.Activations.add(new Activation(tskip2, "allred_1", TransitionOperation.Move, "allred_2"));
	            
	    tskip2.GuardMappingList.add(grdT2_skip);
	
	    tskip2.Delay = 1;
	    pn.Transitions.add(tskip2);
        
        // Transition T5  
        PetriTransition t5 = new PetriTransition(pn);
        t5.TransitionName = "T5";
        t5.InputPlaceName.add("r1g2r3r4");
        t5.InputPlaceName.add("yellow");
        
        Condition T5CttransIndex = new Condition(t5, "r1g2r3r4", TransitionCondition.NotNull);

        GuardMapping grdT5 = new GuardMapping();
        grdT5.condition= T5CttransIndex;
        grdT5.Activations.add(new Activation(t5, "r1g2r3r4", TransitionOperation.Move, "r1y2r3r4"));
        grdT5.Activations.add(new Activation(t5, "yellow", TransitionOperation.SendOverNetwork, "OP2"));
        grdT5.Activations.add(new Activation(t5, "yellow", TransitionOperation.Move, "yellow"));
                
        t5.GuardMappingList.add(grdT5);
    
        t5.Delay = 5;
        pn.Transitions.add(t5);
        
            
        // Transition T6  
        PetriTransition t6 = new PetriTransition(pn);
        t6.TransitionName = "T6";
        t6.InputPlaceName.add("r1y2r3r4");
        t6.InputPlaceName.add("red");
        
        Condition T6CttransIndex = new Condition(t6, "r1y2r3r4", TransitionCondition.NotNull);

        GuardMapping grdT6 = new GuardMapping();
        grdT6.condition= T6CttransIndex;
        grdT6.Activations.add(new Activation(t6, "r1y2r3r4", TransitionOperation.Move, "allred_2"));
        grdT6.Activations.add(new Activation(t6, "red", TransitionOperation.SendOverNetwork, "OP2"));
        grdT6.Activations.add(new Activation(t6, "red", TransitionOperation.Move, "red"));
                
        t6.GuardMappingList.add(grdT6);
    
        t6.Delay = 2;
        pn.Transitions.add(t6);
        
            
        // Transition T7  
        PetriTransition t7 = new PetriTransition(pn);
        t7.TransitionName = "T7";
        t7.InputPlaceName.add("allred_2");
        t7.InputPlaceName.add("green");
        t7.InputPlaceName.add("SENSOR3C");
        
        Condition T7CttransIndex = new Condition(t7, "allred_2", TransitionCondition.NotNull);
        Condition T7CttransIndex2 = new Condition(t7, "SENSOR3C", TransitionCondition.NotNull);
        T7CttransIndex.SetNextCondition(LogicConnector.AND, T7CttransIndex2);

        GuardMapping grdT7 = new GuardMapping();
        grdT7.condition= T7CttransIndex;
        grdT7.Activations.add(new Activation(t7, "allred_2", TransitionOperation.Move, "r1r2g3r4"));
        grdT7.Activations.add(new Activation(t7, "green", TransitionOperation.SendOverNetwork, "OP3"));
        grdT7.Activations.add(new Activation(t7, "green", TransitionOperation.Move, "green"));
                
        t7.GuardMappingList.add(grdT7);
    
        t7.Delay = 1;
        pn.Transitions.add(t7);
        
        // Skip lane 3
        PetriTransition tskip3 = new PetriTransition(pn);
        tskip3.TransitionName = "Tskip3";
        tskip3.InputPlaceName.add("allred_2");
        tskip3.InputPlaceName.add("SENSOR3C");
	    
	    Condition T7CttransIndex_skip = new Condition(tskip3, "allred_2", TransitionCondition.NotNull);
	    Condition T7CttransIndex_skip2 = new Condition(tskip3, "SENSOR3C", TransitionCondition.IsNull);
	    T7CttransIndex_skip.SetNextCondition(LogicConnector.AND, T7CttransIndex_skip2);
	
	    GuardMapping grdT3_skip = new GuardMapping();
	    grdT3_skip.condition= T7CttransIndex_skip;
	    grdT3_skip.Activations.add(new Activation(tskip3, "allred_2", TransitionOperation.Move, "allred_3"));
	            
	    tskip3.GuardMappingList.add(grdT3_skip);
	
	    tskip3.Delay = 1;
	    pn.Transitions.add(tskip3);
        
        // Transition T8  
        PetriTransition t8 = new PetriTransition(pn);
        t8.TransitionName = "T8";
        t8.InputPlaceName.add("r1r2g3r4");
        t8.InputPlaceName.add("yellow");
        
        Condition T8CttransIndex = new Condition(t8, "r1r2g3r4", TransitionCondition.NotNull);

        GuardMapping grdT8 = new GuardMapping();
        grdT8.condition= T8CttransIndex;
        grdT8.Activations.add(new Activation(t8, "r1r2g3r4", TransitionOperation.Move, "r1r2y3r4"));
        grdT8.Activations.add(new Activation(t8, "yellow", TransitionOperation.SendOverNetwork, "OP3"));
        grdT8.Activations.add(new Activation(t8, "yellow", TransitionOperation.Move, "yellow"));
                
        t8.GuardMappingList.add(grdT8);
    
        t8.Delay = 5;
        pn.Transitions.add(t8);
        
            
        // Transition T9  
        PetriTransition t9 = new PetriTransition(pn);
        t9.TransitionName = "T9";
        t9.InputPlaceName.add("r1r2y3r4");
        t9.InputPlaceName.add("red");
        
        Condition T9CttransIndex = new Condition(t9, "r1r2y3r4", TransitionCondition.NotNull);

        GuardMapping grdT9 = new GuardMapping();
        grdT9.condition= T9CttransIndex;
        grdT9.Activations.add(new Activation(t9, "r1r2y3r4", TransitionOperation.Move, "allred_3"));
        grdT9.Activations.add(new Activation(t9, "red", TransitionOperation.SendOverNetwork, "OP3"));
        grdT9.Activations.add(new Activation(t9, "red", TransitionOperation.Move, "red"));
                
        t9.GuardMappingList.add(grdT9);
    
        t9.Delay = 2;
        pn.Transitions.add(t9);
        
            
        // Transition T10  
        PetriTransition t10 = new PetriTransition(pn);
        t10.TransitionName = "T10";
        t10.InputPlaceName.add("allred_3");
        t10.InputPlaceName.add("green");
        
        Condition T10CttransIndex = new Condition(t10, "allred_3", TransitionCondition.NotNull);

        GuardMapping grdT10 = new GuardMapping();
        grdT10.condition= T10CttransIndex;
        grdT10.Activations.add(new Activation(t10, "allred_3", TransitionOperation.Move, "r1r2r3g4"));
        grdT10.Activations.add(new Activation(t10, "green", TransitionOperation.SendOverNetwork, "OP4"));
        grdT10.Activations.add(new Activation(t10, "green", TransitionOperation.Move, "green"));
                
        t10.GuardMappingList.add(grdT10);
    
        t10.Delay = 5;
        pn.Transitions.add(t10);
        
            
        // Transition T11  
        PetriTransition t11 = new PetriTransition(pn);
        t11.TransitionName = "T11";
        t11.InputPlaceName.add("r1r2r3g4");
        t11.InputPlaceName.add("yellow");
        
        Condition T11CttransIndex = new Condition(t11, "r1r2r3g4", TransitionCondition.NotNull);

        GuardMapping grdT11 = new GuardMapping();
        grdT11.condition= T11CttransIndex;
        grdT11.Activations.add(new Activation(t11, "r1r2r3g4", TransitionOperation.Move, "r1r2r3y4"));
        grdT11.Activations.add(new Activation(t11, "yellow", TransitionOperation.SendOverNetwork, "OP4"));
        grdT11.Activations.add(new Activation(t11, "yellow", TransitionOperation.Move, "yellow"));
                
        t11.GuardMappingList.add(grdT11);
    
        t11.Delay = 2;
        pn.Transitions.add(t11);
        
            
        // Transition T12  
        PetriTransition t12 = new PetriTransition(pn);
        t12.TransitionName = "T12";
        t12.InputPlaceName.add("r1r2r3y4");
        t12.InputPlaceName.add("red");
        
        Condition T12CttransIndex = new Condition(t12, "r1r2r3y4", TransitionCondition.NotNull);

        GuardMapping grdT12 = new GuardMapping();
        grdT12.condition= T12CttransIndex;
        grdT12.Activations.add(new Activation(t12, "r1r2r3y4", TransitionOperation.Move, "r1r2r3r4"));
        grdT12.Activations.add(new Activation(t12, "red", TransitionOperation.SendOverNetwork, "OP4"));
        grdT12.Activations.add(new Activation(t12, "red", TransitionOperation.Move, "red"));
                
        t12.GuardMappingList.add(grdT12);
    
        t12.Delay = 1;
        pn.Transitions.add(t12);
        
        
		
		// -------------------------------------------------------------------------------------
		// ----------------------------PN Start-------------------------------------------------
		// -------------------------------------------------------------------------------------

		System.out.println("Controller Right started \n ------------------------------");
		pn.Delay = 2000;
		// pn.Start();

		PetriNetWindow frame = new PetriNetWindow();
		frame.petriNet = pn;
		frame.setVisible(true);
		
		
			
		
		
	}
}
