package verwaltung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class VerwaltungController {
	
	private VerwaltungView view;

	public VerwaltungController(VerwaltungView view) {
		this.view = view;
	}

	public ActionListener getActionListener() {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == view.getBtnNeu() ) {
					//System.out.println("Neu");
					perform_btn_neu();
				}
				
				if(e.getSource() == view.getBtnAen()) {
					//System.out.println("Ändern");
					perform_btn_aen();
				}
				
				if(e.getSource() == view.getBtnLoe() ) {
					//System.out.println("Löschen");
					perform_btn_loe();
				}
				
				if(e.getSource() == view.getBtnSpe()) {
					//System.out.println("Speichern");
					perform_btn_spe();
				}

				
			}
			
		};
	}

	public ListSelectionListener getListSelectionListener() {
		// TODO Auto-generated method stub
		return new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(!e.getValueIsAdjusting()) {
					updateListe();
				}
				
			}
			
		};
	}
	
	
	public void updateListe() {
		Teilnehmer tn = (Teilnehmer) view.getListe().getSelectedValue();
		if(tn != null) {
			
			view.getTfTnr().setText(tn.getTnr());
			view.getTfGruppe().setText(tn.getGruppe());
			view.getTfName().setText(tn.getName());
			view.getTfVorname().setText(tn.getVorname());
			
			
		}
	}
	
	// ### Button Reaktionen #####
	public void perform_btn_neu() {
		
	}
	
	public void perform_btn_aen() {
		
	}

	public void perform_btn_loe() {
		
		int index = view.getListe().getSelectedIndex();
		if(index != -1) {
			view.getDlm().remove(index);
			view.getTfTnr().setText("");
			view.getTfGruppe().setText("");
			view.getTfName().setText("");
			view.getTfVorname().setText("");
		}
		
	}
	
	public void perform_btn_spe() {
		
	}
	
	// CSV-Datei einlesen
	public void leseDatei() {

		try {
			//Datei öffnen
			FileReader fr = new FileReader("teilnehmer.csv");
			BufferedReader br = new BufferedReader(fr);
			
			// 1. Zeile mit Spaltenbeschriftungen
			String header = br.readLine();
			
			String zeile = "";
			// liest aktuelle Zeile, speichert das in "zeile", und schaut ob weitere Zeilen gibt (!=null)
			while((zeile = br.readLine()) != null) {
				// Zeile aufsplitten bei jedem Semikolon
				StringTokenizer st = new StringTokenizer(zeile, ";");
				String tnr = st.nextToken();
				String gruppe = st.nextToken();
				String name = st.nextToken();
				String vorname = st.nextToken();
				
				// Teilnehmer erzeugen
				Teilnehmer tn = new Teilnehmer(tnr, gruppe, name, vorname);
				view.getDlm().addElement(tn);
			}
			br.close();
			fr.close();
			
		}catch(Exception e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}


	
}
