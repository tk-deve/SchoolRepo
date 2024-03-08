package verwaltung;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class VerwaltungView {

	private JFrame frame;
	
	private JPanel mainPanel;
	private JPanel tnPanel;
	private JPanel inputPanel;
	private JPanel labelPanel;
	private JPanel textPanel;
	private JPanel listePanel;
	private JPanel buttonPanel;
	
	private JTextField tfTnr;
	private JTextField tfGruppe;
	private JTextField tfName;
	private JTextField tfVorname;
	
	private JButton btnNeu;
	private JButton btnAen;
	private JButton btnLoe;
	private JButton btnSpe;
	
	private DefaultListModel dlm = new DefaultListModel();
	private JList liste = new JList(dlm);
	
	private VerwaltungController controller = new VerwaltungController(this);
	
	// Konstruktor
	public VerwaltungView() {
		
		frame = new JFrame("Teilnehmerverwaltung");			
		
		// labelPanel (blau)
		labelPanel = new JPanel(new GridLayout(0, 1, 10, 10));
		labelPanel.add(new JLabel("TN-Nr.", JLabel.RIGHT));
		labelPanel.add(new JLabel("Gruppe", JLabel.RIGHT));
		labelPanel.add(new JLabel("Name", JLabel.RIGHT));
		labelPanel.add(new JLabel("Vorname", JLabel.RIGHT));
		
		// textPanel (blau)
		textPanel = new JPanel(new GridLayout(0, 1, 10, 10));
		tfTnr = new JTextField();
		textPanel.add(tfTnr);
		tfGruppe = new JTextField();
		textPanel.add(tfGruppe);
		tfName = new JTextField();
		textPanel.add(tfName);
		tfVorname = new JTextField();
		textPanel.add(tfVorname);
		
		// inputPanel (grün)
		inputPanel = new JPanel(new BorderLayout(10, 10));	
		inputPanel.setBorder(new TitledBorder("Teilnehmer"));
		inputPanel.add(labelPanel, BorderLayout.WEST);
		inputPanel.add(textPanel, BorderLayout.CENTER);
		
		buttonPanel = new JPanel(new FlowLayout());
		btnNeu = new JButton("Neu");
		buttonPanel.add(btnNeu);
		btnAen = new JButton("Ändern");
		buttonPanel.add(btnAen);
		btnLoe = new JButton("Löschen");
		buttonPanel.add(btnLoe);
		btnSpe = new JButton("Speichern");
		buttonPanel.add(btnSpe);
		
		// tnPanel (rot)
		tnPanel = new JPanel(new BorderLayout(10,10));	
		tnPanel.add(inputPanel, BorderLayout.NORTH);
		tnPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		// liste Panel (blau)
		listePanel = new JPanel(new BorderLayout());
		listePanel.setBorder(new TitledBorder("TN-Liste"));
		listePanel.add(new JScrollPane(liste));
		
		// mainPanel (braun)
		mainPanel = new JPanel(new BorderLayout(10, 10));
		mainPanel.add(tnPanel, BorderLayout.WEST);
		mainPanel.add(listePanel, BorderLayout.CENTER);
		
		
		//Actionlistener / Listlistener
		btnNeu.addActionListener(controller.getActionListener());
		btnAen.addActionListener(controller.getActionListener());
		btnLoe.addActionListener(controller.getActionListener());
		btnSpe.addActionListener(controller.getActionListener());
		
		liste.addListSelectionListener(controller.getListSelectionListener());
		
		// Daten einlesen
		controller.leseDatei();
		
		frame.add(mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,400);
		frame.setVisible(true);
	
	}//Ende Konstruktor
	
	// Getter & Setter

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public JPanel getTnPanel() {
		return tnPanel;
	}

	public void setTnPanel(JPanel tnPanel) {
		this.tnPanel = tnPanel;
	}

	public JPanel getInputPanel() {
		return inputPanel;
	}

	public void setInputPanel(JPanel inputPanel) {
		this.inputPanel = inputPanel;
	}

	public JPanel getLabelPanel() {
		return labelPanel;
	}

	public void setLabelPanel(JPanel labelPanel) {
		this.labelPanel = labelPanel;
	}

	public JPanel getTextPanel() {
		return textPanel;
	}

	public void setTextPanel(JPanel textPanel) {
		this.textPanel = textPanel;
	}

	public JPanel getListePanel() {
		return listePanel;
	}

	public void setListePanel(JPanel listePanel) {
		this.listePanel = listePanel;
	}

	public JPanel getButtonPanel() {
		return buttonPanel;
	}

	public void setButtonPanel(JPanel buttonPanel) {
		this.buttonPanel = buttonPanel;
	}

	public JTextField getTfTnr() {
		return tfTnr;
	}

	public void setTfTnr(JTextField tfTnr) {
		this.tfTnr = tfTnr;
	}

	public JTextField getTfGruppe() {
		return tfGruppe;
	}

	public void setTfGruppe(JTextField tfGruppe) {
		this.tfGruppe = tfGruppe;
	}

	public JTextField getTfName() {
		return tfName;
	}

	public void setTfName(JTextField tfName) {
		this.tfName = tfName;
	}

	public JTextField getTfVorname() {
		return tfVorname;
	}

	public void setTfVorname(JTextField tfVorname) {
		this.tfVorname = tfVorname;
	}

	public JButton getBtnNeu() {
		return btnNeu;
	}

	public void setBtnNeu(JButton btnNeu) {
		this.btnNeu = btnNeu;
	}

	public JButton getBtnAen() {
		return btnAen;
	}

	public void setBtnAen(JButton btnAen) {
		this.btnAen = btnAen;
	}

	public JButton getBtnLoe() {
		return btnLoe;
	}

	public void setBtnLoe(JButton btnLoe) {
		this.btnLoe = btnLoe;
	}

	public JButton getBtnSpe() {
		return btnSpe;
	}

	public void setBtnSpe(JButton btnSpe) {
		this.btnSpe = btnSpe;
	}

	public DefaultListModel getDlm() {
		return dlm;
	}

	public void setDlm(DefaultListModel dlm) {
		this.dlm = dlm;
	}

	public JList getListe() {
		return liste;
	}

	public void setListe(JList liste) {
		this.liste = liste;
	}
	
	
	
}
