/*
* /**
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
*/
package org.osate.xtext.aadl2.ui.labeling;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.osate.aadl2.AadlInteger;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AadlReal;
import org.osate.aadl2.AbstractImplementation;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.BusAccess;
import org.osate.aadl2.BusImplementation;
import org.osate.aadl2.BusType;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataImplementation;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.DataType;
import org.osate.aadl2.DeviceImplementation;
import org.osate.aadl2.DeviceType;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.EventPort;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.MemoryImplementation;
import org.osate.aadl2.MemoryType;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PrivatePackageSection;
import org.osate.aadl2.ProcessImplementation;
import org.osate.aadl2.ProcessType;
import org.osate.aadl2.ProcessorImplementation;
import org.osate.aadl2.ProcessorType;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.SubprogramAccess;
import org.osate.aadl2.SubprogramGroupImplementation;
import org.osate.aadl2.SubprogramGroupType;
import org.osate.aadl2.SubprogramImplementation;
import org.osate.aadl2.SubprogramType;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.SystemSubcomponent;
import org.osate.aadl2.SystemType;
import org.osate.aadl2.ThreadGroupImplementation;
import org.osate.aadl2.ThreadGroupType;
import org.osate.aadl2.ThreadImplementation;
import org.osate.aadl2.ThreadType;
import org.osate.aadl2.VirtualBusImplementation;
import org.osate.aadl2.VirtualBusType;
import org.osate.aadl2.VirtualProcessorImplementation;
import org.osate.aadl2.VirtualProcessorType;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 *
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class Aadl2LabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	public Aadl2LabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}


	//Labels and icons can be computed like this:

	String text(AadlPackage ele) {
		  return "Package "+ele.getName();
		}
	String text(PublicPackageSection ele) {
		  return "Package Public "+ele.getName();
		}
	String text(PrivatePackageSection ele) {
		  return "Package Private "+ele.getName();
		}
	String text(SystemType ele) {
		  return "System "+ele.getName();
		}
	String text(ProcessorType ele) {
		  return "Processor "+ele.getName();
		}
	String text(DataType ele) {
		  return "Data "+ele.getName();
		}
	String text(ProcessType ele) {
		  return "Process "+ele.getName();
		}
	String text(ThreadGroupType ele) {
		  return "Thread Group "+ele.getName();
		}
	String text(ThreadType ele) {
		  return "Thread "+ele.getName();
		}
	String text(SubprogramType ele) {
		  return "Subprogram "+ele.getName();
		}
	String text(SubprogramGroupType ele) {
		  return "Subprogram Group "+ele.getName();
		}
	String text(AbstractType ele) {
		  return "Abstract "+ele.getName();
		}
	String text(BusType ele) {
		  return "Bus "+ele.getName();
		}
	String text(MemoryType ele) {
		  return "Memory "+ele.getName();
		}
	String text(DeviceType ele) {
		  return "Device "+ele.getName();
		}
	String text(VirtualBusType ele) {
		  return "Virtual Bus "+ele.getName();
		}
	String text(VirtualProcessorType ele) {
		  return "Virtual Processor "+ele.getName();
		}
	String text(SystemImplementation ele) {
		  return "System Impl "+ele.getName();
		}
	String text(DataImplementation ele) {
		  return "Data Impl "+ele.getName();
		}
	String text(ProcessorImplementation ele) {
		  return "Processor Impl "+ele.getName();
		}
	String text(ProcessImplementation ele) {
		  return "Process Impl "+ele.getName();
		}
	String text(ThreadGroupImplementation ele) {
		  return "Thread Group Impl "+ele.getName();
		}
	String text(ThreadImplementation ele) {
		  return "Thread Impl "+ele.getName();
		}
	String text(SubprogramImplementation ele) {
		  return "Subprogram Impl "+ele.getName();
		}
	String text(SubprogramGroupImplementation ele) {
		  return "Subprogram Group Impl "+ele.getName();
		}
	String text(AbstractImplementation ele) {
		  return "Abstract Impl "+ele.getName();
		}
	String text(BusImplementation ele) {
		  return "Bus Impl "+ele.getName();
		}
	String text(MemoryImplementation ele) {
		  return "Memory Impl "+ele.getName();
		}
	String text(DeviceImplementation ele) {
		  return "Device Impl "+ele.getName();
		}
	String text(VirtualBusImplementation ele) {
		  return "Virtual Bus Impl "+ele.getName();
		}
	String text(VirtualProcessorImplementation ele) {
		  return "Virtual Processor Impl "+ele.getName();
		}

	// Property set and properties
	String text(PropertySet ele) {
		  return "Propertyset "+ele.getName();
		}

	String text(PropertyType ele) {
		if (ele.getName()==null) return "Unnamed Property Type";
		  return "Property Type  "+ele.getName();
	}

	String text(PropertyConstant ele) {
		  return "Property Constant "+ele.getName();
		}

	String text(Property ele) {
		  return "Property "+ele.getName();
		}

	String text(PropertyAssociation ele) {
		if (ele.getProperty()!= null)
		  return "Property "+ele.getProperty().getName()+" =>";
		return "Property =>";
		}

	String text(ModalPropertyValue ele) {
		EList<Mode> ml = ele.getInModes();
		if (ml.isEmpty())
		  return "Property value ";
		String modes = "";
		for (Mode m : ml)
			modes = modes + " "+m.getName();
		return "Modal property value ("+modes+")";
		}


	// these next ones we need only if we go deeper than classifiers
	String text(SystemSubcomponent ele) {
		  return "System Subcomponent "+ele.getName();
		}
	String text(DataSubcomponent ele) {
		  return "Data Subcomponent "+ele.getName();
		}
	String text(EventPort ele) {
		  return "Event Port "+ele.getName();
		}
	String text(DataPort ele) {
		  return "Data Port "+ele.getName();
		}
	String text(EventDataPort ele) {
		  return "Event Data Port "+ele.getName();
		}
	String text(FeatureGroup ele) {
		  return "Feature Group "+ele.getName();
		}
	String text(Feature ele) {
		  return "Feature "+ele.getName();
		}
	String text(BusAccess ele) {
		  return ele.getKind().getName()+" Bus Access "+ele.getName();
		}
	String text(DataAccess ele) {
		  return ele.getKind().getName()+" Data Access "+ele.getName();
		}
	String text(SubprogramAccess ele) {
		  return ele.getKind().getName()+" Subprogram Access "+ele.getName();
		}
	String text(Mode ele) {
		  return "Mode "+ele.getName();
		}
	String text(ModeTransition ele) {
		  return "Mode Transition "+ele.getSource().getName()+" -> "+ele.getDestination().getName();
		}

	String text(NamedValue ele) {
		  return "NamedValue: "+ele.getNamedValue();
	}


	String text(IntegerLiteral ele) {
		  return "int "+ele.getValue();
	}
	String text(RealLiteral ele) {
		  return "real "+ele.getValue();
	}


	String text(ListValue ele) {
		  return "()";
		}
	String text(AadlInteger ele) {
		  return "aadlinteger";
		}
	String text(AadlReal ele) {
		  return "aadlreal";
		}


    String image(NamedElement ele) {
        return ele.eClass().getName() + ".gif";
      }

    String image(PropertyType ele) {
        return "PropertyType.gif";
      }

    String image(ComponentInstance ele) {
        ComponentCategory cat =((ComponentInstance)ele).getCategory();
        if (cat != null){
        	String name = cat.getLiteral();
        	int idx = name.indexOf(" ");
        	if (idx < 0){
               return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase()+".gif";
        	} else {
        		return name.substring(0, 1).toUpperCase() + name.substring(1,idx).toLowerCase()
        		+ name.substring(idx+1, idx+2).toUpperCase()+ name.substring(idx+2).toLowerCase()+".gif";
        	}
        }
        if (ele instanceof SystemInstance)
        	return "System.gif";
    	return ele.eClass().getName() + ".gif";
      }

}
