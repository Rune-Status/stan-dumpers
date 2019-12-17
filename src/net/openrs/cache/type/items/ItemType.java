package net.openrs.cache.type.items;

import java.nio.ByteBuffer;
import net.openrs.util.ByteBufferUtils;

public class ItemType implements net.openrs.cache.type.Type
{
  public int xan2d = 0;
  public int cost = 1;
  public int zoom2d = 2000;
  public int yan2d = 0;
  public int zan2d = 0;
  public int yOffset2d = 0;
  public int stackable = 0;
  public boolean members = false;
  public int xOffset2d = 0;
  private final int id;
  public String[] options;
  public String[] interfaceOptions;
  public String name;
  public int maleModel0;
  public int maleModel1;
  public int maleOffset;
  public int femaleModel0;
  public int femaleModel1;
  public int femaleOffset;
  public int maleModel2;
  public int femaleModel2;
  public int maleHeadModel;
  public int maleHeadModel2;
  public int femaleHeadModel;
  public int femaleHeadModel2;
  public int notedID;
  public int notedTemplate;
  public int resizeX;
  public int resizeY;
  public int resizeZ;
  public int ambient;
  public int contrast;
  public int team;
  public int inventoryModel;
  public short[] colorFind;
  public short[] colorReplace;
  public short[] textureFind;
  public short[] textureReplace;
  public boolean stockMarket;
  public int[] countObj;
  public int[] countCo;
  public int boughtLink;
  public int boughtTemplate;
  
  public ItemType(int id) {
    this.id = id;
    options = new String[5];
    interfaceOptions = new String[5];
    name = null;
    maleModel0 = -1;
    maleModel1 = -1;
    maleOffset = 0;
    femaleModel0 = -1;
    femaleModel1 = -1;
    femaleOffset = 0;
    maleModel2 = -1;
    femaleModel2 = -1;
    maleHeadModel = -1;
    maleHeadModel2 = -1;
    femaleHeadModel = -1;
    femaleHeadModel2 = -1;
    notedID = -1;
    notedTemplate = -1;
    resizeX = 0;
    resizeY = 0;
    resizeZ = 0;
    ambient = 0;
    contrast = 0;
    team = 0;
  }
  
  public void decode(ByteBuffer buffer) {
    for (;;) {
      int opcode = buffer.get() & 0xFF;
      if (opcode == 0) {
        return;
      }
      
      if (opcode == 1) {
        inventoryModel = (buffer.getShort() & 0xFFFF);
      } else if (opcode == 2) {
        name = ByteBufferUtils.getString(buffer);
        if (id == 13309) {
          System.out.println(name);
        }
      } else if (opcode == 4) {
        zoom2d = (buffer.getShort() & 0xFFFF);
      } else if (opcode == 5) {
        xan2d = (buffer.getShort() & 0xFFFF);
      } else if (opcode == 6) {
        yan2d = (buffer.getShort() & 0xFFFF);
      } else if (7 == opcode) {
        xOffset2d = (buffer.getShort() & 0xFFFF);
        if (xOffset2d > 32767) {
          xOffset2d -= 65536;
        }
      } else if (8 == opcode) {
        yOffset2d = (buffer.getShort() & 0xFFFF);
        if (yOffset2d > 32767) {
          yOffset2d -= 65536;
        }
      } else if (11 == opcode) {
        stackable = 1;
      } else if (opcode == 12) {
        cost = buffer.getInt();
      } else if (16 == opcode) {
        members = true;
      } else if (opcode == 23) {
        maleModel0 = (buffer.getShort() & 0xFFFF);
        maleOffset = (buffer.get() & 0xFF);
      } else if (opcode == 24) {
        maleModel1 = (buffer.getShort() & 0xFFFF);
      } else if (25 == opcode) {
        femaleModel0 = (buffer.getShort() & 0xFFFF);
        femaleOffset = (buffer.get() & 0xFF);
      } else if (26 == opcode) {
        femaleModel1 = (buffer.getShort() & 0xFFFF);
      } else if ((opcode >= 30) && (opcode < 35)) {
        options[(opcode - 30)] = ByteBufferUtils.getString(buffer);
        if (options[(opcode - 30)].equalsIgnoreCase("Hidden")) {
          options[(opcode - 30)] = null;
        }
      } else if ((opcode >= 35) && (opcode < 40)) {
        interfaceOptions[(opcode - 35)] = ByteBufferUtils.getString(buffer);
      }
      else
      {
        if (opcode == 40) {
          int length = buffer.get() & 0xFF;
          colorFind = new short[length];
          colorReplace = new short[length];
          
          for (int idx = 0; idx < length; idx++) {
            colorFind[idx] = ((short)(buffer.getShort() & 0xFFFF));
            colorReplace[idx] = ((short)(buffer.getShort() & 0xFFFF));
          } }
        if (opcode == 41) {
          int length = buffer.get() & 0xFF;
          textureFind = new short[length];
          textureReplace = new short[length];
          
          for (int idx = 0; idx < length; idx++) {
            textureFind[idx] = ((short)(buffer.getShort() & 0xFFFF));
            textureReplace[idx] = ((short)(buffer.getShort() & 0xFFFF));
          } }
        if (opcode == 42) {
          buffer.get();
        } else if (opcode == 65) {
          stockMarket = true;
        } else if (opcode == 78) {
          maleModel2 = (buffer.getShort() & 0xFFFF);
        } else if (opcode == 79) {
          femaleModel2 = (buffer.getShort() & 0xFFFF);
        } else if (90 == opcode) {
          maleHeadModel = (buffer.getShort() & 0xFFFF);
        } else if (91 == opcode) {
          femaleHeadModel = (buffer.getShort() & 0xFFFF);
        } else if (92 == opcode) {
          maleHeadModel2 = (buffer.getShort() & 0xFFFF);
        } else if (opcode == 93) {
          femaleHeadModel2 = (buffer.getShort() & 0xFFFF);
        } else if (opcode == 95) {
          zan2d = (buffer.getShort() & 0xFFFF);
        } else if (97 == opcode) {
          notedID = (buffer.getShort() & 0xFFFF);
        } else if (98 == opcode) {
          notedTemplate = (buffer.getShort() & 0xFFFF);
        } else if ((opcode >= 100) && (opcode < 110)) {
          if (countObj == null) {
            countObj = new int[10];
            countCo = new int[10];
          }
          
          countObj[(opcode - 100)] = (buffer.getShort() & 0xFFFF);
          countCo[(opcode - 100)] = (buffer.getShort() & 0xFFFF);
        } else if (110 == opcode) {
          resizeX = (buffer.getShort() & 0xFFFF);
        } else if (opcode == 111) {
          resizeY = (buffer.getShort() & 0xFFFF);
        } else if (opcode == 112) {
          resizeZ = (buffer.getShort() & 0xFFFF);
        } else if (opcode == 113) {
          ambient = buffer.get();
        } else if (114 == opcode) {
          contrast = buffer.get();
        } else if (115 == opcode) {
          team = (buffer.get() & 0xFF);
        } else if (opcode == 139) {
          boughtLink = (buffer.getShort() & 0xFFFF);
        } else if (opcode == 140) {
          boughtTemplate = (buffer.getShort() & 0xFFFF); } else { int length;
          if (opcode == 148) {
            length = buffer.getShort() & 0xFFFF; 
            } else if (opcode == 149) {
              length = buffer.getShort() & 0xFFFF;
            } else if (opcode == 249)
            {
              int var2 = buffer.get() & 0xFF;        
              for (int var3 = 0; var3 < var2; var3++) {
                boolean var6 = (buffer.get() & 0xFF) == 1;
                
                for (int i = 0; i < 3; i++) {
                  buffer.get();
                }                

                if (var6) {
                  ByteBufferUtils.getString(buffer);
                }
                else {
                  buffer.getInt();
                }
              }
            }
          }
        }
      }
    }
  


  public ByteBuffer encode()
  {
    ByteBuffer buffer = ByteBuffer.allocate(1132);
    return (ByteBuffer)buffer.flip();
  }
  
  public int getAmbient() {
    return ambient;
  }
  
  public int getBoughtLink() {
    return boughtLink;
  }
  
  public int getBoughtTemplate() {
    return boughtTemplate;
  }
  
  public short[] getColorFind() {
    return colorFind;
  }
  
  public short[] getColorReplace() {
    return colorReplace;
  }
  
  public int getContrast() {
    return contrast;
  }
  
  public int getCost() {
    return cost;
  }
  
  public int[] getCountCo() {
    return countCo;
  }
  
  public int[] getCountObj() {
    return countObj;
  }
  
  public int getFemaleHeadModel() {
    return femaleHeadModel;
  }
  
  public int getFemaleHeadModel2() {
    return femaleHeadModel2;
  }
  
  public int getFemaleModel0() {
    return femaleModel0;
  }
  
  public int getFemaleModel1() {
    return femaleModel1;
  }
  
  public int getFemaleModel2() {
    return femaleModel2;
  }
  
  public int getFemaleOffset() {
    return femaleOffset;
  }
  
  public int getID() {
    return id;
  }
  
  public String[] getInterfaceOptions() {
    return interfaceOptions;
  }
  
  public int getInventoryModel() {
    return inventoryModel;
  }
  
  public int getMaleHeadModel() {
    return maleHeadModel;
  }
  
  public int getMaleHeadModel2() {
    return maleHeadModel2;
  }
  
  public int getMaleModel0() {
    return maleModel0;
  }
  
  public int getMaleModel1() {
    return maleModel1;
  }
  
  public int getMaleModel2() {
    return maleModel2;
  }
  
  public int getMaleOffset() {
    return maleOffset;
  }
  
  public String getName() {
    return name;
  }
  
  public int getNotedID() {
    return notedID;
  }
  
  public int getNotedTemplate() {
    return notedTemplate;
  }
  
  public String[] getOptions() {
    return options;
  }
  
  public int getResizeX() {
    return resizeX;
  }
  
  public int getResizeY() {
    return resizeY;
  }
  
  public int getResizeZ() {
    return resizeZ;
  }
  
  public int getTeam() {
    return team;
  }
  
  public short[] getTextureFind() {
    return textureFind;
  }
  
  public short[] getTextureReplace() {
    return textureReplace;
  }
  
  public int getXan2d() {
    return xan2d;
  }
  
  public int getxOffset2d() {
    return xOffset2d;
  }
  
  public int getYan2d() {
    return yan2d;
  }
  
  public int getyOffset2d() {
    return yOffset2d;
  }
  
  public int getZan2d() {
    return zan2d;
  }
  
  public int getZoom2d() {
    return zoom2d;
  }
  
  public boolean isMembers() {
    return members;
  }
  
  public boolean isStackable() {
    return stackable == 1;
  }
  
  public boolean isStockMarket() {
    return stockMarket;
  }
  
  @Override
	public ByteBuffer encode317() {
		ByteBuffer buffer = ByteBuffer.allocate(1132);
		return (ByteBuffer) buffer.flip();
	}
}
