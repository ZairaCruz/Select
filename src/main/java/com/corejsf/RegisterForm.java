package com.corejsf;

import java.awt.Color;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@ManagedBean (name="form")
@SessionScoped
public class RegisterForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public enum Education {EnsinoMédio, Bacharel, Mestrado, Doutorado};
	
	public static class Weekday{
		private int dayOfWeek;
		public Weekday(int dayOfWeek){
			this.dayOfWeek = dayOfWeek;
		}
		public String getDayName(){
			DateFormatSymbols symbols = new DateFormatSymbols();
			String[] weekdays = symbols.getWeekdays();
			return weekdays[dayOfWeek];
		}
		public int getDayNumber(){
			return dayOfWeek;
		}
	}
	
	private String name;
	private boolean contactMe;
	private String contarctar;
	private String[] bestDayToContact;
	private Integer yearOfBirth;
	private int[] colors;
	private Set<String> languages = new TreeSet<String>();
	private Education education = Education.Bacharel;
	
	public String getName() {
		return name;
	}
	public void setName(String newValue) {
		name = newValue;
	}
	public boolean isContactMe() {
		return contactMe;
	}
	
	public void setContactMe(boolean newValue) {
		contactMe = newValue;
	}
	public String[] getBestDayToContact() {
		return bestDayToContact;
	}
	public void setBestDayToContact(String[] bestDayToContact) {
		this.bestDayToContact =bestDayToContact;
	}
	public Integer getYearOfBirth() {
		return yearOfBirth;
	}
	public void setYearOfBirth(Integer newValue) {
		yearOfBirth = newValue;
	}
	public int[] getColors() {
		return colors;
	}
	public void setColors(int[] newValue) {
		colors = newValue;
	}
	public Set<String> getLanguages() {
		return languages;
	}
	public void setLanguages(Set<String> newValue) {
		languages = newValue;
	}
	public Education getEducation() {
		return education;
	}
	public void setEducation(Education newValue) {
		
		education = newValue;
	}
	
	public Collection<SelectItem> getYearItems(){
		return birthYear;
	}
	
	public Weekday[] getDaysOfTheWeek(){
		return daysOfTheWeek;
	}
	
	public SelectItem[] getLanguageItems(){
		return languageItems;
	}
	
	public SelectItem[] getColorItems(){
		return colorItems;
	}
	
	public Map<String, Education> getEducationItems(){
		return educationItems;
	}
	
	public String getBestDayConcatenated(){
		return Arrays.toString(bestDayToContact);
	}
	
	public String getColorsConcatenated(){
		StringBuilder result = new StringBuilder();
		for(int color: colors) result.append(String.format("%06x ", color));
		return result.toString();
	}
	
	public String getContarctar() {
		return contarctar;
	}
	public void setContarctar(String contarctar) {
		this.contarctar = contarctar;
	}

	private SelectItem[] colorItems = {
			new SelectItem(Color.RED.getRGB(), "Vermelho"), //VALOR, ROTULO
			new SelectItem(Color.GREEN.getRGB(), "Verde"),
			new SelectItem(Color.BLUE.getRGB(), "Azul"),
			new SelectItem(Color.YELLOW.getRGB(), "Amarelo"),
			new SelectItem(Color.ORANGE.getRGB(), "Laranja", "", true)//DESABILITADO
	};
	
	private static Map<String, Education> educationItems;
	static{
		educationItems = new LinkedHashMap<String, Education>();
		educationItems.put("Ensino Médio", Education.EnsinoMédio); //VALOR, ROTULO
		educationItems.put("Bacharel", Education.Bacharel);
		educationItems.put("Mestrado", Education.Mestrado);
		educationItems.put("Doutorado", Education.Doutorado);
	};
	
	private static SelectItem[] languageItems ={
		new SelectItem("Inglês"),
		new SelectItem("Francês"),
		new SelectItem("Russo"),
		new SelectItem("Italiano"),
		new SelectItem("Esperanto", "Esperanto", "", true)// DESABILITADO
	};
	
	private static Collection<SelectItem> birthYear;
	static{
		birthYear = new ArrayList<SelectItem>();
		// THE FIRST ITEM IS A "NO SELECTON" item
		birthYear.add(new SelectItem(null, "Ano de nascimento:", "", false, false, true));
		for(int i= 2016; i >1900; i--)
			birthYear.add(new SelectItem(i));
	}
	
	private static Weekday[] daysOfTheWeek;
	
	static{
		daysOfTheWeek = new Weekday[7];
		for(int i= Calendar.SUNDAY; i<= Calendar.SATURDAY; i++){
			daysOfTheWeek[i - Calendar.SUNDAY] = new Weekday(i);
			
		}
		
	}
}
