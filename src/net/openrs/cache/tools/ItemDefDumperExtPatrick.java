package net.openrs.cache.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.gson.stream.JsonWriter;

import net.openrs.cache.tools.ItemDefDumper.Item;

public class ItemDefDumperExtPatrick {
	
	public static final String EXPORT = "C:/Users/Stan/Desktop/RS/osrscache/type/ItemDefinitionsPatrick.json";
	
	public static final String LISTFILE = "C:/Users/Stan/Desktop/RS/osrscache/type/items.txt";
	
	static String readFile(String path, Charset encoding) 
	  throws IOException 
	{
	  byte[] encoded = Files.readAllBytes(Paths.get(path));
	  return new String(encoded, encoding);
	}
	
	static void addAttr(Document doc, Element el, String key, String value) {
		Element attr = doc.createElement(key);
		attr.appendChild(doc.createTextNode(value));
		el.appendChild(attr);
	}
	
	static class Item {
		String name = "Null";
		int id = -1;
		boolean members = false;
		boolean forceUntradable = false;
		boolean tradable = false;
		boolean stackable = false;
		boolean equipable = false;
		boolean maleModel = false;
		int highAlch = 0;
		int lowAlch = 0;
		int geprice = 0;
		double weight = 0;
		String examine = "Unknown";
		String slot = "";
		boolean twoHanded = false;
		boolean helm = false;
		boolean mask = false;
		boolean body = false;
		int speed = 0;
		int[] bonusses = new int[14];
		int[] requirements = new int[23];
		boolean note = false;
		boolean noteable = false;
		int unnotedId = -1;
		int notedId = -1;
	}
	
	public static boolean stringContainsItemFromList(String inputStr, List<String> strings) {
	    return Arrays.stream((String[]) strings.toArray()).parallel().anyMatch(inputStr::contains);
	}

	public static void main(String[] args) throws Exception {
		
		JsonWriter json = new JsonWriter(new FileWriter(EXPORT));
		json.setIndent("  ");
		json.beginArray();
		
		Item item = new Item();
		
		boolean finished = false;
		
		int maxId = 21207;
	    
	    List<Item> items = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(LISTFILE))) {
		    String line;
		    while (!finished) {
		    	line = br.readLine();
			    if(line.startsWith("case ")) {
			    	item = new Item();
			    	line = line.replace("case ", "");
			    	line = line.replace(":", "");
			    	item.id = Integer.parseInt(line);
			    } else if(line.contains("type.name")) {
			    	line = line.replace("type.name = \"", "");
			    	line = line.replace("\";", "");
			    	line = line.replace("&", "and");
			    	item.name = line.trim();	
			    	
			    	if(item.name.contains(" arrow") || item.name.contains(" knife") || item.name.contains(" dart") || item.name.contains(" bolts")) {
			    		item.stackable = true;
			    	}
			    		
			    	String url = "http://2007.runescape.wikia.com/wiki/" + item.name.replaceAll(" ", "_");
			    	org.jsoup.nodes.Document document = null;
			    	try {
				        document = Jsoup.connect(url).timeout(60000).get();		
			        } catch (HttpStatusException e) {
			        	if(item.name.contains("Burnt ")) {
			        		item.examine = "Oh dear, it's totally burnt!";
			        		item.tradable = true;
			        	} else if(item.name.contains("(kp)")) {
			        		url = "http://2007.runescape.wikia.com/wiki/" + item.name.replaceAll(" ", "_").substring(0, item.name.length() - 4);
			        		document = Jsoup.connect(url).get();
			        	} else if(item.name.contains("Ahrim") || item.name.contains("Dharok") || item.name.contains("Guthan") || item.name.contains("Karil") || item.name.contains("Torag") || item.name.contains("Verac")) {
			        		if(item.name.contains("100")) {
				        		url = "http://2007.runescape.wikia.com/wiki/" + item.name.replaceAll(" ", "_").substring(0, item.name.length() - 4);
			        		} else {
				        		url = "http://2007.runescape.wikia.com/wiki/" + item.name.replaceAll(" ", "_").substring(0, item.name.length() - 3);
				        		item.forceUntradable = true;
			        		}
			        		document = Jsoup.connect(url).get();
			        	} else if(item.name.contains("- pt")) {
			        		url = "http://2007.runescape.wikia.com/wiki/" + item.name.substring(0, item.name.length() - 6).replaceAll(" ", "_");
			        		document = Jsoup.connect(url).get();
			        	} else if(item.name.contains("(m1)") || item.name.contains("(m2)") || item.name.contains("(m3)") || item.name.contains("(m4)") || item.name.contains("(10)")) {
			        		url = "http://2007.runescape.wikia.com/wiki/" + item.name.substring(0, item.name.length() - 4).trim().replaceAll(" ", "_");
			        		document = Jsoup.connect(url).get();
			        	} else if((item.name.contains("(0)") || item.name.contains("(1)") || item.name.contains("(2)") || item.name.contains("(3)") || item.name.contains("(4)") || item.name.contains("(5)") || item.name.contains("(6)") || item.name.contains("(7)") || item.name.contains("(8)") || item.name.contains("(9)") || item.name.contains("(o)")) && !item.name.contains("Mixture")) {
			        		url = "http://2007.runescape.wikia.com/wiki/" + item.name.substring(0, item.name.length() - 3).trim().replaceAll(" ", "_");
			        		try {
						        document = Jsoup.connect(url).timeout(60000).get();		
					        } catch (HttpStatusException ex) {
					        	
					        }
			        	} else if((item.name.endsWith("0") || item.name.endsWith("1") || item.name.endsWith("2") || item.name.endsWith("3") || item.name.endsWith("4") || item.name.endsWith("5") || item.name.endsWith("6") || item.name.endsWith("7") || item.name.endsWith("8") || item.name.endsWith("9") || item.name.endsWith("10")) && !item.name.contains("Magical balance") && !item.name.contains("Rune case") && !item.name.contains("Godsword shards")) {
			        		url = "http://2007.runescape.wikia.com/wiki/" + item.name.substring(0, item.name.length() - 2).trim().replaceAll(" ", "_");
			        		document = Jsoup.connect(url).get();
			        	} else if(item.name.endsWith("cape(t)")) {
			        		url = "http://2007.runescape.wikia.com/wiki/" + item.name.substring(0, item.name.length() - 3).trim().replaceAll(" ", "_").replaceAll("Woodcut.", "Woodcutting");
			        		document = Jsoup.connect(url).get();
			        	} else if(item.name.contains("hat and")) {
			        		url = "http://2007.runescape.wikia.com/wiki/" + item.name.replaceAll("hat and", "hat %26").replaceAll(" ", "_");
			        		document = Jsoup.connect(url).get();
			        	} else if(item.name.contains(" (uncharged)")) {
			        		url = "http://2007.runescape.wikia.com/wiki/" + item.name.substring(0, item.name.length() - 12).replaceAll(" ", "_");
			        		document = Jsoup.connect(url).get();
			        	} else if(item.name.contains("Dragon javelin(p")) {
			        		url = "http://2007.runescape.wikia.com/wiki/Dragon_javelin";
			        		document = Jsoup.connect(url).get();
			        	}
			        	
			        }
			    	
			    	if(document != null) {
//			    		if(item.id > 21048) {
//				    		Elements sprite = document.select(".wikitable.infobox tr > td > a > img");
//		        			if(sprite.first() != null) {
//		        				try(InputStream in = new URL(sprite.first().attr("src")).openStream()){
//					    		    Files.copy(in, Paths.get("C:/Users/Stan/Desktop/Item sprites/" + item.id + ".png"));
//					    		} catch(IOException e) {
//					    			System.out.println(e.getMessage());
//					    		}
//		        			}
//			    		}
			    		boolean examineNext = false;
				    	Elements list = document.select(".wikitable.infobox tr");
				        for (org.jsoup.nodes.Element infoBox : list) {
				        	String text = infoBox.text();
				        	if(examineNext) {
				        		item.examine = text;
				        		examineNext = false;
				        	} else if(text.contains("Yes")) {
				        		if(text.contains("Members only")) {
				        			item.members = true;
				        		} else if(text.contains("Tradeable")) {
				        			item.tradable = true;
				        			Elements gemain = document.select("#GEPrice");
				        			Elements ge = document.select("#GEPrice .GEItem > span");
				        			if(gemain.text().contains("dose")) {
				        				if(item.name.contains("4")) {
				        					item.geprice = Integer.parseInt(ge.get(ge.size() - 4).text().replace(",", ""));
				        				} else if(item.name.contains("3")) {
				        					item.geprice = Integer.parseInt(ge.get(ge.size() - 3).text().replace(",", ""));
				        				} else if(item.name.contains("2")) {
				        					item.geprice = Integer.parseInt(ge.get(ge.size() - 2).text().replace(",", ""));
				        				} else if(item.name.contains("1")) {
				        					item.geprice = Integer.parseInt(ge.get(ge.size() - 1).text().replace(",", ""));
				        				}
				        			} else if(ge.first() != null && !ge.first().text().contains("error")) {
				        				item.geprice = Integer.parseInt(ge.first().text().replace(",", "").replaceAll("Clean:", ""));
				        			}
				        		} else if(text.contains("Equipable") && !text.contains("if the player does not unwield it ") && !item.name.contains("Fishing bait")) {
				        			item.equipable = true;
				        			Elements bonusTable = document.select(".wikitable.smallpadding tr > td");
				        			int bonusIndex = 0;
				        			for(org.jsoup.nodes.Element bonusNumber : bonusTable) {
				        				if(bonusIndex < 14) {
					        				try {
				        						if(bonusNumber.text().contains("to")) {
				        							item.bonusses[bonusIndex] = Integer.parseInt(bonusNumber.text().replaceAll("%", "").replaceAll("\\(+4 trimmed\\)", "").split("to")[1].trim().replaceAll("\u00A0", ""));
				        						} else {
				        							item.bonusses[bonusIndex] = Integer.parseInt(bonusNumber.text().replaceAll("%", "").replaceAll("\\(+4 trimmed\\)", ""));
				        						}
				        						bonusIndex++;		
					        				} catch (NumberFormatException e) {}
				        				}
				        			}
				        			Elements slotElement = document.select(".wikitable.smallpadding tr th p a");
				        			if(slotElement.last() != null) {
			        					switch(slotElement.last().attr("title").replaceAll(" slot table", "")) {
			        						case "Head":
			        							item.slot = "HAT";
			        							if(item.name.toLowerCase().contains("helm") && item.name.toLowerCase().contains("full")) {
			        								item.helm = true;
			        							} else if(item.name.toLowerCase().contains("mask")) {
			        								item.mask = true;
			        							}
			        							break;
			        						case "Cape":
			        							item.slot = "CAPE";
			        							break;
			        						case "Neck":
			        							item.slot = "AMULET";
			        							break;
			        						case "Ammunition":
			        						case "Ammo":
			        							item.slot = "ARROWS";
			        							break;
			        						case "Weapon":
			        							item.slot = "WEAPON";
			        							if(document.select(".wikitable.smallpadding tr th span img").last().attr("alt").contains("Monster")) {
			        								item.speed = Integer.parseInt(document.select(".wikitable.smallpadding tr th span img").last().attr("alt").replace("Monster attack speed", "").trim());
			        							}
			        							break;
			        						case "Two-handed":
			        						case "2h":
			        							item.twoHanded = true;
			        							item.slot = "WEAPON";
			        							if(document.select(".wikitable.smallpadding tr th span img").last().attr("alt").contains("Monster")) {
			        								item.speed = Integer.parseInt(document.select(".wikitable.smallpadding tr th span img").last().attr("alt").replace("Monster attack speed", "").trim());
			        							}
			        							break;
			        						case "Body":
			        							item.slot = "CHEST";
			        							if(item.name.toLowerCase().contains("body") || item.name.toLowerCase().contains("shirt") || item.name.toLowerCase().contains("robe")  || item.name.toLowerCase().contains("robetop") || item.name.toLowerCase().contains("chestplate")) {
			        								item.body = true;
			        							}
			        							break;
			        						case "Shield":
			        							item.slot = "SHIELD";
			        							break;
			        						case "Legwear":
			        						case "Legs":
			        							item.slot = "LEGS";
			        							break;
			        						case "Hands":
			        							item.slot = "HANDS";
			        							break;
			        						case "Feet":
			        							item.slot = "FEET";
			        							break;
			        						case "Ring":
			        							item.slot = "RING";
			        							break;
		        							default:
		        								System.out.println("SLOT NIET BEKEND - " + slotElement.last().attr("title").replaceAll(" slot table", ""));
		        								break;
			        					}
				        			}
				        			if(item.name.contains("cape(t)")) {
				        				item.bonusses[13] = 4;
				        			}
				        		} else if(text.contains("Stackable")) {
				        			item.stackable = true;
				        		}
				        	} else if(text.contains(" Alch") && !text.contains("Varies") && !text.contains("unknown") && !text.contains("Various") && !text.contains("N/A") && !text.contains("herbs")) {
				        		text = infoBox.children().last().text();
				        		if(text.contains("doses")) {
				        			text = text.split("doses: ")[1];
				        			if(text.split(",").length > 1) {
				        				text = text.split(",")[Integer.parseInt(item.name.substring(item.name.length() - 2, item.name.length() - 1)) - 1];
				        			}
				        		} else if(text.contains("Whole")) {
				        			text = text.split("Half")[0].split("Whole:")[1];
				        		} else if(text.contains("dose =")) {
				        			text = infoBox.children().last().text().replaceAll("dose", "").split("=")[Integer.parseInt(item.name.substring(item.name.length() - 2, item.name.length() - 1)) - 1].replaceAll("=", "");
				        		} else if(text.contains("Rune:")) {
				        			if(item.name.contains("Steel")) {
				        				text = text.split("Rune:")[0];
				        			} else {
				        				text = text.split("Rune:")[1];
				        			}
				        			text = text.replaceAll("Steel:", "");
				        		} else if(text.contains("-")) {
				        			if(text.split("-").length > 1) {
				        				text = text.split("-")[Integer.parseInt(item.name.substring(item.name.length() - 2, item.name.length() - 1)) - 1];
				        			}
				        		}
				        		if(infoBox.text().contains("High Alch") && !text.contains("Unknown") && !text.contains("?")) {
				        			item.highAlch = Integer.parseInt(text.split("coins")[0].split("coin")[0].split("\\(")[0].replaceAll("Clean:", "").replaceAll("coins", "").replaceAll("coin", "").trim().replace(",", "").replaceAll("\u00A0", ""));
				        		} else if(infoBox.text().contains("Low Alch") && !text.contains("Unknown") && !text.contains("?")) {
				        			item.lowAlch = Integer.parseInt(text.split("coins")[0].split("coin")[0].split("\\(")[0].replaceAll("Clean:", "").replaceAll("coins", "").replaceAll("coin", "").trim().replace(",", "").replaceAll("\u00A0", ""));
				        		}
				        	} else if(text.contains("Weight") && !text.contains("Unknown") && !text.contains("No")) {
			        			if(text.contains("Equipped")) {
			        				item.weight = Double.parseDouble(infoBox.children().last().text().split("Equipped:")[1].split("kg")[0].replaceAll("\u00A0", ""));
			        			} else if(text.contains("(full)")) {
			        				item.weight = Double.parseDouble(infoBox.children().last().text().split("\\(full\\)")[1].split("kg")[0].replaceAll("\u00A0", ""));
			        			} else if(text.contains("Whole:")) {
			        				item.weight = Double.parseDouble(infoBox.children().last().text().split("Half")[0].split("Whole:")[1].split("kg")[0].replaceAll("\u00A0", ""));
			        			} else if(text.contains("Raw:")) {
			        				item.weight = Double.parseDouble(infoBox.children().last().text().split("Cooked")[0].split("Raw:")[1].split("kg")[0].replaceAll("\u00A0", ""));
			        			} else {
			        				item.weight = Double.parseDouble(infoBox.children().last().text().split(",")[0].split("to")[0].split("kg")[0].replaceAll("\u00A0", "").replaceAll(">", "").replaceAll("<", "").replaceAll("~", ""));
			        			}
			        		} else if(text.contains("Examine")) {
			        			examineNext = true;
			        		}
				        }
				        
				        if(item.name.contains("Clue scroll")) {
				        	item.examine = "A set of instructions to be followed.";
				        }
				        
				        if(item.forceUntradable) {
				        	item.tradable = false;
				        }
			    	}
			    	
			    } else if(line.contains("type.notedID")) {
			    	line = line.replace("type.notedID = ", "");
			    	line = line.replace(";", "");
			    	item.notedId = Integer.parseInt(line.trim());
			    } else if(line.contains("type.notedTemplate")) {
			    	item.note = true;
			    } else if(line.contains("type.maleModel0")) {
			    	item.maleModel = true;
			    } else if(line.contains("break;")) {
			    	if(item.note) {
			    		int id = item.id;
			    		int notedId = item.notedId;
			    		item = items.get(notedId);
			    		item.id = id;
			    		item.notedId = notedId;
			    		item.unnotedId = notedId;
			    		item.note = true;
			    		item.stackable = true;
			    		item.equipable = false;
			    		item.stackable = true;
			    		item.helm = false;
			    		item.body = false;
			    		item.mask = false;
						Arrays.fill(item.bonusses, 0);
						item.slot = "";
						item.weight = 0;
						item.speed = 0;
			    		item.examine = "Swap this note at any bank for the equivalent item.";
			    	}
			    	if(item.id != -1) {
			    		if(item.id % 1000 == 0) {
			    			System.out.println(item.id);
			    		}
			    		if(item.id == 995) {
			    			item.stackable = true;
			    		}
			    		String itemname = item.name.toLowerCase();
			    		if (itemname.contains("steel")) {
			    			if ((itemname.contains("sword")) || (itemname.contains("scimitar")) || (itemname.contains("battleaxe"))
			    					|| (itemname.contains("warhammer")) || (itemname.contains("spear")) || (itemname.contains("dagger"))) {
			    				item.requirements[0] = 5;
			    			} else if ((itemname.contains("platebody")) || (itemname.contains("chainbody")) || (itemname.contains("boots"))
			    					|| (itemname.contains("legs")) || (itemname.contains("skirt")) || (itemname.contains("gloves"))
			    					|| (itemname.contains("shield")) || (itemname.contains("defender"))) {
			    				item.requirements[1] = 5;
			    			} else if ((itemname.contains("knife")) || (itemname.contains("thrownaxe")) || (itemname.contains("javelin"))
			    					|| (itemname.contains("dart"))) {
			    				item.requirements[4] = 5;
			    			}
			    		} else if (itemname.contains("black")) {
			    			if ((itemname.contains("sword")) || (itemname.contains("scimitar")) || (itemname.contains("battleaxe"))
			    					|| (itemname.contains("warhammer")) || (itemname.contains("spear")) || (itemname.contains("dagger"))) {
			    				item.requirements[0] = 10;
			    			} else if ((itemname.contains("platebody")) || (itemname.contains("chainbody")) || (itemname.contains("boots"))
			    					|| (itemname.contains("legs")) || (itemname.contains("skirt")) || (itemname.contains("gloves"))
			    					|| (itemname.contains("shield")) || (itemname.contains("defender"))) {
			    				item.requirements[1] = 10;
			    			} else if ((itemname.contains("knife")) || (itemname.contains("thrownaxe")) || (itemname.contains("javelin"))
			    					|| (itemname.contains("dart"))) {
			    				item.requirements[4] = 10;
			    			}
			    			if (itemname.contains("d'hide")) {
			    				if (itemname.contains("body")) {
			    					item.requirements[1] = 40;
			    					item.requirements[4] = 70;
			    				} else if ((itemname.contains("chaps")) || (itemname.contains("vamb"))) {
			    					item.requirements[4] = 70;
			    				}
			    			}
			    		} else if (itemname.contains("mithril")) {
			    			if ((itemname.contains("sword")) || (itemname.contains("scimitar")) || (itemname.contains("battleaxe"))
			    					|| (itemname.contains("warhammer")) || (itemname.contains("spear")) || (itemname.contains("dagger"))) {
			    				item.requirements[0] = 20;
			    			} else if ((itemname.contains("platebody")) || (itemname.contains("chainbody")) || (itemname.contains("boots"))
			    					|| (itemname.contains("legs")) || (itemname.contains("skirt")) || (itemname.contains("gloves"))
			    					|| (itemname.contains("shield")) || (itemname.contains("defender"))) {
			    				item.requirements[1] = 20;
			    			} else if ((itemname.contains("knife")) || (itemname.contains("thrownaxe")) || (itemname.contains("javelin"))
			    					|| (itemname.contains("dart"))) {
			    				item.requirements[4] = 20;
			    			}
			    		} else if (itemname.contains("adamant")) {
			    			if ((itemname.contains("sword")) || (itemname.contains("scimitar")) || (itemname.contains("battleaxe"))
			    					|| (itemname.contains("warhammer")) || (itemname.contains("spear")) || (itemname.contains("dagger"))) {
			    				item.requirements[0] = 30;
			    			} else if ((itemname.contains("platebody")) || (itemname.contains("chainbody")) || (itemname.contains("boots"))
			    					|| (itemname.contains("legs")) || (itemname.contains("skirt")) || (itemname.contains("gloves"))
			    					|| (itemname.contains("shield")) || (itemname.contains("defender"))) {
			    				item.requirements[1] = 30;
			    			} else if ((itemname.contains("knife")) || (itemname.contains("thrownaxe")) || (itemname.contains("javelin"))
			    					|| (itemname.contains("dart"))) {
			    				item.requirements[4] = 30;
			    			}
			    		} else if (itemname.contains("rune")) {
			    			if ((itemname.contains("sword")) || (itemname.contains("scimitar")) || (itemname.contains("battleaxe"))
			    					|| (itemname.contains("warhammer")) || (itemname.contains("spear")) || (itemname.contains("dagger"))) {
			    				item.requirements[0] = 40;
			    			} else if ((itemname.contains("platebody")) || (itemname.contains("chainbody")) || (itemname.contains("boots"))
			    					|| (itemname.contains("legs")) || (itemname.contains("skirt")) || (itemname.contains("gloves"))
			    					|| (itemname.contains("shield")) || (itemname.contains("defender"))) {
			    				item.requirements[1] = 40;
			    			} else if ((itemname.contains("knife")) || (itemname.contains("thrownaxe")) || (itemname.contains("javelin"))
			    					|| (itemname.contains("dart"))) {
			    				item.requirements[4] = 40;
			    			}
			    		} else if (itemname.contains("dragon")) {
			    			if ((itemname.contains("sword")) || (itemname.contains("scimitar")) || (itemname.contains("battleaxe"))
			    					|| (itemname.contains("warhammer")) || (itemname.contains("spear")) || (itemname.contains("dagger"))) {
			    				item.requirements[0] = 60;
			    			} else if ((itemname.contains("platebody")) || (itemname.contains("chainbody")) || (itemname.contains("boots"))
			    					|| (itemname.contains("legs")) || (itemname.contains("skirt")) || (itemname.contains("gloves"))
			    					|| (itemname.contains("shield")) || (itemname.contains("defender"))) {
			    				item.requirements[1] = 60;
			    			} else if ((itemname.contains("knife")) || (itemname.contains("thrownaxe")) || (itemname.contains("javelin"))
			    					|| (itemname.contains("dart"))) {
			    				item.requirements[4] = 60;
			    			}
			    		}
			    		if (itemname.contains("godsword")) {
			    			item.requirements[0] = 75;
			    		}
			    		if (itemname.contains("neitiznot")) {
			    			item.requirements[1] = 55;
			    		}
			    		if ((itemname.contains("berserker helm")) || (itemname.contains("farseer helm")) || (itemname.contains("archer helm"))
			    				|| (itemname.contains("warrior helm"))) {
			    			item.requirements[1] = 45;
			    		}
			    		if (itemname.contains("abyssal")) {
			    			item.requirements[0] = 70;
			    		}
			    		if (itemname.contains("dharok")) {
			    			if (itemname.contains("greataxe")) {
			    				item.requirements[0] = 70;
			    				item.requirements[2] = 70;
			    			} else {
			    				item.requirements[1] = 70;
			    			}
			    		}
			    		if (itemname.contains("torag")) {
			    			if (itemname.contains("hammer")) {
			    				item.requirements[0] = 70;
			    				item.requirements[2] = 70;
			    			} else {
			    				item.requirements[1] = 70;
			    			}
			    		}
			    		if (itemname.contains("verac")) {
			    			if (itemname.contains("flail")) {
			    				item.requirements[0] = 70;
			    				item.requirements[2] = 70;
			    			} else {
			    				item.requirements[1] = 70;
			    			}
			    		}
			    		if (itemname.contains("guthan")) {
			    			if (itemname.contains("spear")) {
			    				item.requirements[0] = 70;
			    				item.requirements[2] = 70;
			    			} else {
			    				item.requirements[1] = 70;
			    			}
			    		}
			    		if (itemname.contains("karil")) {
			    			if (itemname.contains("bow")) {
			    				item.requirements[4] = 70;
			    			} else {
			    				item.requirements[4] = 70;
			    				item.requirements[1] = 70;
			    			}
			    		}
			    		if (itemname.contains("ahrim")) {
			    			if (itemname.contains("bow")) {
			    				item.requirements[6] = 70;
			    			} else {
			    				item.requirements[6] = 70;
			    				item.requirements[1] = 70;
			    			}
			    		}
			    		if (itemname.contains("d'hide")) {
			    			if (itemname.contains("blue")) {
			    				if (itemname.contains("body")) {
			    					item.requirements[1] = 40;
			    					item.requirements[4] = 50;
			    				} else if ((itemname.contains("chaps")) || (itemname.contains("vamb"))) {
			    					item.requirements[4] = 50;
			    				}
			    			}
			    			if (itemname.contains("green")) {
			    				if (itemname.contains("body")) {
			    					item.requirements[1] = 40;
			    					item.requirements[4] = 40;
			    				} else if ((itemname.contains("chaps")) || (itemname.contains("vamb"))) {
			    					item.requirements[4] = 40;
			    				}
			    			}
			    			if (itemname.contains("red")) {
			    				if (itemname.contains("body")) {
			    					item.requirements[1] = 40;
			    					item.requirements[4] = 60;
			    				} else if ((itemname.contains("chaps")) || (itemname.contains("vamb"))) {
			    					item.requirements[4] = 60;
			    				}
			    			}
			    		}
			    		if (itemname.contains("staff of the dead")) {
			    			item.requirements[0] = 75;
			    			item.requirements[6] = 75;
			    		}
			    		if (itemname.contains("void knight")) {
			    			item.requirements[0] = 42;
			    			item.requirements[1] = 42;
			    			item.requirements[2] = 42;
			    			item.requirements[3] = 42;
			    			item.requirements[4] = 42;
			    			item.requirements[6] = 42;
			    		}
			    		if (itemname.contains("spirit shield")) {
			    			item.requirements[1] = 45;
			    			item.requirements[5] = 55;
			    			if (itemname.contains("blessed")) {
			    				item.requirements[1] = 70;
			    				item.requirements[5] = 85;
			    			}
			    			if (itemname.contains("arcane")) {
			    				item.requirements[1] = 75;
			    				item.requirements[5] = 70;
			    				item.requirements[6] = 65;
			    			}
			    			if (itemname.contains("spectral")) {
			    				item.requirements[1] = 75;
			    				item.requirements[5] = 70;
			    				item.requirements[6] = 65;
			    			}
			    			if (itemname.contains("elysian")) {
			    				item.requirements[1] = 75;
			    				item.requirements[5] = 75;
			    			}
			    		}
			    		json.beginObject();
			    		json.name("id");
			    		json.value(item.id);
			    		json.name("name");
			    		json.value(item.name);
			    		json.name("description");
			    		json.value(item.examine.replace("�", "").replace("�", "..."));
//			    		json.name("members");
//			    		json.value(item.members);
//			    		json.name("attackSpeed");
//			    		json.value(item.speed);
			    		
//			    		json.name("extraDefinitions");
//			    		json.value(false);
			    		
			    		json.name("equipment-slot");
			    		if(item.slot == "") {
			    			json.value(-1);
			    		} else {
			    			json.value(item.slot.replace("\"", "'"));
			    		}
//			    		json.name("noteable");
//			    		if(!item.note && item.notedId >= 0) {
//			    			json.value(true);
//			    		} else {
//			    			json.value(false);
//			    		}
//			    		json.name("noted");
//			    		json.value(item.note);
			    		json.name("stackable");
			    		json.value(item.stackable);
//			    		json.name("specialPrice");
//			    		json.value(Math.round(item.highAlch * 1.6));
			    		json.name("shop-price");
			    		if(item.geprice > 0) {
			    			json.value(item.geprice);
			    		} else {
			    			json.value(item.highAlch);
			    		}
			    		json.name("low-alch");
			    		json.value(item.lowAlch);
			    		json.name("high-alch");
			    		json.value(item.highAlch);
			    		json.name("bonus");
			    		json.beginArray();
			    		int i = 0;
			    		for(int bonus : item.bonusses) {
//			    			if(i != 11 && i != 12) {
			    				json.value(bonus);
//			    			}
			    			i++;
			    		}
//			    		if(item.slot == -1 && item.maleModel && !item.note) {
//			    			System.out.println(item.id + ": " + item.name);
//			    		}
			    		json.endArray();
			    		json.name("two-handed");
			    		json.value(item.twoHanded);
			    		json.name("full-helm");
			    		json.value(item.helm);
//			    		json.name("fullMask");
//			    		json.value(item.mask);
			    		json.name("platebody");
			    		json.value(item.body);
			    		json.name("tradable");
			    		json.value(item.tradable);
			    		json.name("weight");
			    		json.value(item.weight);
//			    		json.name("unnotedId");
//			    		json.value(item.unnotedId);
			    		json.endObject();
			    		items.add(item);
			    	}
			    	if(item.id == maxId) {
			    		finished = true;
			    	}
			    }
			}
		}
		json.endArray();
		json.flush();
		json.close();
	}
}
