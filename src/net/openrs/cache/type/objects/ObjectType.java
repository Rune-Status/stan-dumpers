package net.openrs.cache.type.objects;

import java.nio.ByteBuffer;
import net.openrs.cache.type.Type;
import net.openrs.util.ByteBufferUtils;




public class ObjectType
  implements Type
{
  public int anInt2069 = 16;
  public boolean isSolid = false;
  public String name = null;
  public int mapIconID = -1;
  public int sizeX = 1;
  public int sizeY = 1;
  public int anInt2083 = 0;
  public int offsetX = 0;
  public boolean nonFlatShading = false;
  public int anInt2088 = -1;
  public int animationID = -1;
  public int varpID = -1;
  public int ambient = 0;
  public int contrast = 0;
  public String[] actions = new String[5];
  public int anInt2094 = -1;
  public int mapSceneID = -1;
  public int anInt768 = -1;
  public boolean aBool2097 = true;
  public int modelSizeX = 128;
  public int modelSizeHeight = 128;
  public int modelSizeY = 128;
  public int offsetHeight = 0;
  public int offsetY = 0;
  public boolean aBool2104 = false;
  public int anInt2105 = -1;
  public int anInt2106 = -1;
  public boolean aBool2108 = false;
  public int configId = -1;
  public int anInt2110 = 2019882883;
  public boolean aBool2111 = false;
  public int anInt2112 = 0;
  public int anInt2113 = 0;
  public boolean aBool2114 = true;
  public final int id;
  public int[] objectModels;
  public int[] objectTypes;
  public short[] recolorToFind;
  public short[] recolorToReplace;
  public short[] retextureToFind;
  public short[] textureToReplace;
  public int[] configChangeDest;
  public int[] anIntArray2084;
  public int objectID;
  
  public ObjectType(int id) {
    this.id = id;
  }
  
  public void boothCheapHax() {
    name = "Bank booth";
    objectModels = new int[] { 1270 };
    String[] arrstring = new String[5];
    arrstring[1] = "Bank";
    arrstring[2] = "Collect";
    actions = arrstring;
    sizeX = 1;
    anInt2088 = 1;
    anInt2094 = -1;
  }
  
  public void decode(ByteBuffer buffer)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 43	java/nio/ByteBuffer:get	()B
    //   4: sipush 255
    //   7: iand
    //   8: dup
    //   9: istore_2
    //   10: ifeq +1201 -> 1211
    //   13: iconst_1
    //   14: iload_2
    //   15: if_icmpne +80 -> 95
    //   18: aload_1
    //   19: invokevirtual 43	java/nio/ByteBuffer:get	()B
    //   22: sipush 255
    //   25: iand
    //   26: istore_3
    //   27: iload_3
    //   28: ifgt +6 -> 34
    //   31: goto -31 -> 0
    //   34: aload_0
    //   35: iload_3
    //   36: newarray int
    //   38: putfield 44	net/openrs/cache/type/objects/ObjectType:objectTypes	[I
    //   41: aload_0
    //   42: iload_3
    //   43: newarray int
    //   45: putfield 40	net/openrs/cache/type/objects/ObjectType:objectModels	[I
    //   48: iconst_0
    //   49: istore 4
    //   51: iload 4
    //   53: iload_3
    //   54: if_icmplt +6 -> 60
    //   57: goto -57 -> 0
    //   60: aload_0
    //   61: getfield 40	net/openrs/cache/type/objects/ObjectType:objectModels	[I
    //   64: iload 4
    //   66: aload_1
    //   67: invokevirtual 45	java/nio/ByteBuffer:getShort	()S
    //   70: ldc 46
    //   72: iand
    //   73: iastore
    //   74: aload_0
    //   75: getfield 44	net/openrs/cache/type/objects/ObjectType:objectTypes	[I
    //   78: iload 4
    //   80: aload_1
    //   81: invokevirtual 43	java/nio/ByteBuffer:get	()B
    //   84: sipush 255
    //   87: iand
    //   88: iastore
    //   89: iinc 4 1
    //   92: goto -41 -> 51
    //   95: iload_2
    //   96: iconst_2
    //   97: if_icmpne +14 -> 111
    //   100: aload_0
    //   101: aload_1
    //   102: invokestatic 47	net/openrs/util/ByteBufferUtils:getString	(Ljava/nio/ByteBuffer;)Ljava/lang/String;
    //   105: putfield 4	net/openrs/cache/type/objects/ObjectType:name	Ljava/lang/String;
    //   108: goto -108 -> 0
    //   111: iload_2
    //   112: iconst_5
    //   113: if_icmpne +63 -> 176
    //   116: aload_1
    //   117: invokevirtual 43	java/nio/ByteBuffer:get	()B
    //   120: sipush 255
    //   123: iand
    //   124: istore_3
    //   125: iload_3
    //   126: ifgt +6 -> 132
    //   129: goto -129 -> 0
    //   132: aload_0
    //   133: aconst_null
    //   134: putfield 44	net/openrs/cache/type/objects/ObjectType:objectTypes	[I
    //   137: aload_0
    //   138: iload_3
    //   139: newarray int
    //   141: putfield 40	net/openrs/cache/type/objects/ObjectType:objectModels	[I
    //   144: iconst_0
    //   145: istore 4
    //   147: iload 4
    //   149: iload_3
    //   150: if_icmplt +6 -> 156
    //   153: goto -153 -> 0
    //   156: aload_0
    //   157: getfield 40	net/openrs/cache/type/objects/ObjectType:objectModels	[I
    //   160: iload 4
    //   162: aload_1
    //   163: invokevirtual 45	java/nio/ByteBuffer:getShort	()S
    //   166: ldc 46
    //   168: iand
    //   169: iastore
    //   170: iinc 4 1
    //   173: goto -26 -> 147
    //   176: iload_2
    //   177: bipush 14
    //   179: if_icmpne +18 -> 197
    //   182: aload_0
    //   183: aload_1
    //   184: invokevirtual 43	java/nio/ByteBuffer:get	()B
    //   187: sipush 255
    //   190: iand
    //   191: putfield 6	net/openrs/cache/type/objects/ObjectType:sizeX	I
    //   194: goto -194 -> 0
    //   197: bipush 15
    //   199: iload_2
    //   200: if_icmpne +18 -> 218
    //   203: aload_0
    //   204: aload_1
    //   205: invokevirtual 43	java/nio/ByteBuffer:get	()B
    //   208: sipush 255
    //   211: iand
    //   212: putfield 7	net/openrs/cache/type/objects/ObjectType:sizeY	I
    //   215: goto -215 -> 0
    //   218: iload_2
    //   219: bipush 17
    //   221: if_icmpne +11 -> 232
    //   224: aload_0
    //   225: iconst_0
    //   226: putfield 18	net/openrs/cache/type/objects/ObjectType:anInt2094	I
    //   229: goto -229 -> 0
    //   232: iload_2
    //   233: bipush 18
    //   235: if_icmpne +11 -> 246
    //   238: aload_0
    //   239: iconst_0
    //   240: putfield 37	net/openrs/cache/type/objects/ObjectType:aBool2114	Z
    //   243: goto -243 -> 0
    //   246: iload_2
    //   247: bipush 19
    //   249: if_icmpne +18 -> 267
    //   252: aload_0
    //   253: aload_1
    //   254: invokevirtual 43	java/nio/ByteBuffer:get	()B
    //   257: sipush 255
    //   260: iand
    //   261: putfield 11	net/openrs/cache/type/objects/ObjectType:anInt2088	I
    //   264: goto -264 -> 0
    //   267: iload_2
    //   268: bipush 21
    //   270: if_icmpne +11 -> 281
    //   273: aload_0
    //   274: iconst_0
    //   275: putfield 28	net/openrs/cache/type/objects/ObjectType:anInt2105	I
    //   278: goto -278 -> 0
    //   281: bipush 22
    //   283: iload_2
    //   284: if_icmpne +11 -> 295
    //   287: aload_0
    //   288: iconst_1
    //   289: putfield 10	net/openrs/cache/type/objects/ObjectType:nonFlatShading	Z
    //   292: goto -292 -> 0
    //   295: iload_2
    //   296: bipush 23
    //   298: if_icmpne +11 -> 309
    //   301: aload_0
    //   302: iconst_1
    //   303: putfield 34	net/openrs/cache/type/objects/ObjectType:aBool2111	Z
    //   306: goto -306 -> 0
    //   309: bipush 24
    //   311: iload_2
    //   312: if_icmpne +34 -> 346
    //   315: aload_0
    //   316: aload_1
    //   317: invokevirtual 45	java/nio/ByteBuffer:getShort	()S
    //   320: ldc 46
    //   322: iand
    //   323: putfield 12	net/openrs/cache/type/objects/ObjectType:animationID	I
    //   326: aload_0
    //   327: getfield 12	net/openrs/cache/type/objects/ObjectType:animationID	I
    //   330: ldc 46
    //   332: if_icmpeq +6 -> 338
    //   335: goto -335 -> 0
    //   338: aload_0
    //   339: iconst_m1
    //   340: putfield 12	net/openrs/cache/type/objects/ObjectType:animationID	I
    //   343: goto -343 -> 0
    //   346: iload_2
    //   347: bipush 27
    //   349: if_icmpne +11 -> 360
    //   352: aload_0
    //   353: iconst_1
    //   354: putfield 18	net/openrs/cache/type/objects/ObjectType:anInt2094	I
    //   357: goto -357 -> 0
    //   360: iload_2
    //   361: bipush 28
    //   363: if_icmpne +18 -> 381
    //   366: aload_0
    //   367: aload_1
    //   368: invokevirtual 43	java/nio/ByteBuffer:get	()B
    //   371: sipush 255
    //   374: iand
    //   375: putfield 2	net/openrs/cache/type/objects/ObjectType:anInt2069	I
    //   378: goto -378 -> 0
    //   381: iload_2
    //   382: bipush 29
    //   384: if_icmpne +14 -> 398
    //   387: aload_0
    //   388: aload_1
    //   389: invokevirtual 43	java/nio/ByteBuffer:get	()B
    //   392: putfield 14	net/openrs/cache/type/objects/ObjectType:ambient	I
    //   395: goto -395 -> 0
    //   398: iload_2
    //   399: bipush 39
    //   401: if_icmpne +14 -> 415
    //   404: aload_0
    //   405: aload_1
    //   406: invokevirtual 43	java/nio/ByteBuffer:get	()B
    //   409: putfield 15	net/openrs/cache/type/objects/ObjectType:contrast	I
    //   412: goto -412 -> 0
    //   415: iload_2
    //   416: bipush 30
    //   418: if_icmplt +55 -> 473
    //   421: iload_2
    //   422: bipush 35
    //   424: if_icmpge +49 -> 473
    //   427: aload_0
    //   428: getfield 17	net/openrs/cache/type/objects/ObjectType:actions	[Ljava/lang/String;
    //   431: iload_2
    //   432: bipush 30
    //   434: isub
    //   435: aload_1
    //   436: invokestatic 47	net/openrs/util/ByteBufferUtils:getString	(Ljava/nio/ByteBuffer;)Ljava/lang/String;
    //   439: aastore
    //   440: aload_0
    //   441: getfield 17	net/openrs/cache/type/objects/ObjectType:actions	[Ljava/lang/String;
    //   444: iload_2
    //   445: bipush 30
    //   447: isub
    //   448: aaload
    //   449: ldc 48
    //   451: invokevirtual 49	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   454: ifne +6 -> 460
    //   457: goto -457 -> 0
    //   460: aload_0
    //   461: getfield 17	net/openrs/cache/type/objects/ObjectType:actions	[Ljava/lang/String;
    //   464: iload_2
    //   465: bipush 30
    //   467: isub
    //   468: aconst_null
    //   469: aastore
    //   470: goto -470 -> 0
    //   473: iload_2
    //   474: bipush 40
    //   476: if_icmpne +74 -> 550
    //   479: aload_1
    //   480: invokevirtual 43	java/nio/ByteBuffer:get	()B
    //   483: sipush 255
    //   486: iand
    //   487: istore_3
    //   488: aload_0
    //   489: iload_3
    //   490: newarray short
    //   492: putfield 50	net/openrs/cache/type/objects/ObjectType:recolorToFind	[S
    //   495: aload_0
    //   496: iload_3
    //   497: newarray short
    //   499: putfield 51	net/openrs/cache/type/objects/ObjectType:recolorToReplace	[S
    //   502: iconst_0
    //   503: istore 4
    //   505: iload 4
    //   507: iload_3
    //   508: if_icmplt +6 -> 514
    //   511: goto -511 -> 0
    //   514: aload_0
    //   515: getfield 50	net/openrs/cache/type/objects/ObjectType:recolorToFind	[S
    //   518: iload 4
    //   520: aload_1
    //   521: invokevirtual 45	java/nio/ByteBuffer:getShort	()S
    //   524: ldc 46
    //   526: iand
    //   527: i2s
    //   528: sastore
    //   529: aload_0
    //   530: getfield 51	net/openrs/cache/type/objects/ObjectType:recolorToReplace	[S
    //   533: iload 4
    //   535: aload_1
    //   536: invokevirtual 45	java/nio/ByteBuffer:getShort	()S
    //   539: ldc 46
    //   541: iand
    //   542: i2s
    //   543: sastore
    //   544: iinc 4 1
    //   547: goto -42 -> 505
    //   550: iload_2
    //   551: bipush 41
    //   553: if_icmpne +74 -> 627
    //   556: aload_1
    //   557: invokevirtual 43	java/nio/ByteBuffer:get	()B
    //   560: sipush 255
    //   563: iand
    //   564: istore_3
    //   565: aload_0
    //   566: iload_3
    //   567: newarray short
    //   569: putfield 52	net/openrs/cache/type/objects/ObjectType:retextureToFind	[S
    //   572: aload_0
    //   573: iload_3
    //   574: newarray short
    //   576: putfield 53	net/openrs/cache/type/objects/ObjectType:textureToReplace	[S
    //   579: iconst_0
    //   580: istore 4
    //   582: iload 4
    //   584: iload_3
    //   585: if_icmplt +6 -> 591
    //   588: goto -588 -> 0
    //   591: aload_0
    //   592: getfield 52	net/openrs/cache/type/objects/ObjectType:retextureToFind	[S
    //   595: iload 4
    //   597: aload_1
    //   598: invokevirtual 45	java/nio/ByteBuffer:getShort	()S
    //   601: ldc 46
    //   603: iand
    //   604: i2s
    //   605: sastore
    //   606: aload_0
    //   607: getfield 53	net/openrs/cache/type/objects/ObjectType:textureToReplace	[S
    //   610: iload 4
    //   612: aload_1
    //   613: invokevirtual 45	java/nio/ByteBuffer:getShort	()S
    //   616: ldc 46
    //   618: iand
    //   619: i2s
    //   620: sastore
    //   621: iinc 4 1
    //   624: goto -42 -> 582
    //   627: iload_2
    //   628: bipush 60
    //   630: if_icmpne +17 -> 647
    //   633: aload_0
    //   634: aload_1
    //   635: invokevirtual 45	java/nio/ByteBuffer:getShort	()S
    //   638: ldc 46
    //   640: iand
    //   641: putfield 5	net/openrs/cache/type/objects/ObjectType:mapIconID	I
    //   644: goto -644 -> 0
    //   647: bipush 62
    //   649: iload_2
    //   650: if_icmpne +11 -> 661
    //   653: aload_0
    //   654: iconst_1
    //   655: putfield 30	net/openrs/cache/type/objects/ObjectType:aBool2108	Z
    //   658: goto -658 -> 0
    //   661: iload_2
    //   662: bipush 64
    //   664: if_icmpne +11 -> 675
    //   667: aload_0
    //   668: iconst_0
    //   669: putfield 21	net/openrs/cache/type/objects/ObjectType:aBool2097	Z
    //   672: goto -672 -> 0
    //   675: iload_2
    //   676: bipush 65
    //   678: if_icmpne +17 -> 695
    //   681: aload_0
    //   682: aload_1
    //   683: invokevirtual 45	java/nio/ByteBuffer:getShort	()S
    //   686: ldc 46
    //   688: iand
    //   689: putfield 22	net/openrs/cache/type/objects/ObjectType:modelSizeX	I
    //   692: goto -692 -> 0
    //   695: iload_2
    //   696: bipush 66
    //   698: if_icmpne +17 -> 715
    //   701: aload_0
    //   702: aload_1
    //   703: invokevirtual 45	java/nio/ByteBuffer:getShort	()S
    //   706: ldc 46
    //   708: iand
    //   709: putfield 23	net/openrs/cache/type/objects/ObjectType:modelSizeHeight	I
    //   712: goto -712 -> 0
    //   715: bipush 67
    //   717: iload_2
    //   718: if_icmpne +17 -> 735
    //   721: aload_0
    //   722: aload_1
    //   723: invokevirtual 45	java/nio/ByteBuffer:getShort	()S
    //   726: ldc 46
    //   728: iand
    //   729: putfield 24	net/openrs/cache/type/objects/ObjectType:modelSizeY	I
    //   732: goto -732 -> 0
    //   735: iload_2
    //   736: bipush 68
    //   738: if_icmpne +17 -> 755
    //   741: aload_0
    //   742: aload_1
    //   743: invokevirtual 45	java/nio/ByteBuffer:getShort	()S
    //   746: ldc 46
    //   748: iand
    //   749: putfield 19	net/openrs/cache/type/objects/ObjectType:mapSceneID	I
    //   752: goto -752 -> 0
    //   755: iload_2
    //   756: bipush 69
    //   758: if_icmpne +18 -> 776
    //   761: aload_0
    //   762: aload_1
    //   763: invokevirtual 43	java/nio/ByteBuffer:get	()B
    //   766: sipush 255
    //   769: iand
    //   770: putfield 20	net/openrs/cache/type/objects/ObjectType:anInt768	I
    //   773: goto -773 -> 0
    //   776: bipush 70
    //   778: iload_2
    //   779: if_icmpne +17 -> 796
    //   782: aload_0
    //   783: aload_1
    //   784: invokevirtual 45	java/nio/ByteBuffer:getShort	()S
    //   787: ldc 46
    //   789: iand
    //   790: putfield 9	net/openrs/cache/type/objects/ObjectType:offsetX	I
    //   793: goto -793 -> 0
    //   796: iload_2
    //   797: bipush 71
    //   799: if_icmpne +17 -> 816
    //   802: aload_0
    //   803: aload_1
    //   804: invokevirtual 45	java/nio/ByteBuffer:getShort	()S
    //   807: ldc 46
    //   809: iand
    //   810: putfield 25	net/openrs/cache/type/objects/ObjectType:offsetHeight	I
    //   813: goto -813 -> 0
    //   816: iload_2
    //   817: bipush 72
    //   819: if_icmpne +17 -> 836
    //   822: aload_0
    //   823: aload_1
    //   824: invokevirtual 45	java/nio/ByteBuffer:getShort	()S
    //   827: ldc 46
    //   829: iand
    //   830: putfield 26	net/openrs/cache/type/objects/ObjectType:offsetY	I
    //   833: goto -833 -> 0
    //   836: bipush 73
    //   838: iload_2
    //   839: if_icmpne +11 -> 850
    //   842: aload_0
    //   843: iconst_1
    //   844: putfield 27	net/openrs/cache/type/objects/ObjectType:aBool2104	Z
    //   847: goto -847 -> 0
    //   850: bipush 74
    //   852: iload_2
    //   853: if_icmpne +11 -> 864
    //   856: aload_0
    //   857: iconst_1
    //   858: putfield 3	net/openrs/cache/type/objects/ObjectType:isSolid	Z
    //   861: goto -861 -> 0
    //   864: iload_2
    //   865: bipush 75
    //   867: if_icmpne +18 -> 885
    //   870: aload_0
    //   871: aload_1
    //   872: invokevirtual 43	java/nio/ByteBuffer:get	()B
    //   875: sipush 255
    //   878: iand
    //   879: putfield 29	net/openrs/cache/type/objects/ObjectType:anInt2106	I
    //   882: goto -882 -> 0
    //   885: iload_2
    //   886: bipush 77
    //   888: if_icmpeq +170 -> 1058
    //   891: iload_2
    //   892: bipush 92
    //   894: if_icmpeq +164 -> 1058
    //   897: iload_2
    //   898: bipush 78
    //   900: if_icmpne +29 -> 929
    //   903: aload_0
    //   904: aload_1
    //   905: invokevirtual 45	java/nio/ByteBuffer:getShort	()S
    //   908: ldc 46
    //   910: iand
    //   911: putfield 33	net/openrs/cache/type/objects/ObjectType:anInt2110	I
    //   914: aload_0
    //   915: aload_1
    //   916: invokevirtual 43	java/nio/ByteBuffer:get	()B
    //   919: sipush 255
    //   922: iand
    //   923: putfield 8	net/openrs/cache/type/objects/ObjectType:anInt2083	I
    //   926: goto +284 -> 1210
    //   929: iload_2
    //   930: bipush 79
    //   932: if_icmpne +85 -> 1017
    //   935: aload_0
    //   936: aload_1
    //   937: invokevirtual 45	java/nio/ByteBuffer:getShort	()S
    //   940: ldc 46
    //   942: iand
    //   943: putfield 35	net/openrs/cache/type/objects/ObjectType:anInt2112	I
    //   946: aload_0
    //   947: aload_1
    //   948: invokevirtual 45	java/nio/ByteBuffer:getShort	()S
    //   951: ldc 46
    //   953: iand
    //   954: putfield 36	net/openrs/cache/type/objects/ObjectType:anInt2113	I
    //   957: aload_0
    //   958: aload_1
    //   959: invokevirtual 43	java/nio/ByteBuffer:get	()B
    //   962: sipush 255
    //   965: iand
    //   966: putfield 8	net/openrs/cache/type/objects/ObjectType:anInt2083	I
    //   969: aload_1
    //   970: invokevirtual 43	java/nio/ByteBuffer:get	()B
    //   973: sipush 255
    //   976: iand
    //   977: istore_3
    //   978: aload_0
    //   979: iload_3
    //   980: newarray int
    //   982: putfield 54	net/openrs/cache/type/objects/ObjectType:anIntArray2084	[I
    //   985: iconst_0
    //   986: istore 4
    //   988: iload 4
    //   990: iload_3
    //   991: if_icmplt +6 -> 997
    //   994: goto -994 -> 0
    //   997: aload_0
    //   998: getfield 54	net/openrs/cache/type/objects/ObjectType:anIntArray2084	[I
    //   1001: iload 4
    //   1003: aload_1
    //   1004: invokevirtual 45	java/nio/ByteBuffer:getShort	()S
    //   1007: ldc 46
    //   1009: iand
    //   1010: iastore
    //   1011: iinc 4 1
    //   1014: goto -26 -> 988
    //   1017: iload_2
    //   1018: bipush 81
    //   1020: if_icmpne +11 -> 1031
    //   1023: aload_1
    //   1024: invokevirtual 43	java/nio/ByteBuffer:get	()B
    //   1027: pop
    //   1028: goto +182 -> 1210
    //   1031: iload_2
    //   1032: bipush 82
    //   1034: if_icmpne +14 -> 1048
    //   1037: aload_0
    //   1038: aload_1
    //   1039: invokevirtual 45	java/nio/ByteBuffer:getShort	()S
    //   1042: putfield 5	net/openrs/cache/type/objects/ObjectType:mapIconID	I
    //   1045: goto +165 -> 1210
    //   1048: iload_2
    //   1049: sipush 249
    //   1052: if_icmpne +158 -> 1210
    //   1055: goto +155 -> 1210
    //   1058: aload_0
    //   1059: aload_1
    //   1060: invokevirtual 45	java/nio/ByteBuffer:getShort	()S
    //   1063: ldc 46
    //   1065: iand
    //   1066: putfield 13	net/openrs/cache/type/objects/ObjectType:varpID	I
    //   1069: aload_0
    //   1070: getfield 13	net/openrs/cache/type/objects/ObjectType:varpID	I
    //   1073: ldc 46
    //   1075: if_icmpne +8 -> 1083
    //   1078: aload_0
    //   1079: iconst_m1
    //   1080: putfield 13	net/openrs/cache/type/objects/ObjectType:varpID	I
    //   1083: aload_0
    //   1084: aload_1
    //   1085: invokevirtual 45	java/nio/ByteBuffer:getShort	()S
    //   1088: ldc 46
    //   1090: iand
    //   1091: putfield 31	net/openrs/cache/type/objects/ObjectType:configId	I
    //   1094: aload_0
    //   1095: getfield 31	net/openrs/cache/type/objects/ObjectType:configId	I
    //   1098: ldc 46
    //   1100: if_icmpne +8 -> 1108
    //   1103: aload_0
    //   1104: iconst_m1
    //   1105: putfield 31	net/openrs/cache/type/objects/ObjectType:configId	I
    //   1108: iconst_m1
    //   1109: istore 5
    //   1111: iload_2
    //   1112: bipush 92
    //   1114: if_icmpne +19 -> 1133
    //   1117: aload_1
    //   1118: invokevirtual 45	java/nio/ByteBuffer:getShort	()S
    //   1121: istore 5
    //   1123: iload 5
    //   1125: ldc 46
    //   1127: if_icmpne +6 -> 1133
    //   1130: iconst_m1
    //   1131: istore 5
    //   1133: aload_1
    //   1134: invokevirtual 43	java/nio/ByteBuffer:get	()B
    //   1137: sipush 255
    //   1140: iand
    //   1141: istore_3
    //   1142: aload_0
    //   1143: iload_3
    //   1144: iconst_2
    //   1145: iadd
    //   1146: newarray int
    //   1148: putfield 55	net/openrs/cache/type/objects/ObjectType:configChangeDest	[I
    //   1151: iconst_0
    //   1152: istore 6
    //   1154: iload 6
    //   1156: iload_3
    //   1157: if_icmpgt +43 -> 1200
    //   1160: aload_0
    //   1161: getfield 55	net/openrs/cache/type/objects/ObjectType:configChangeDest	[I
    //   1164: iload 6
    //   1166: aload_1
    //   1167: invokevirtual 45	java/nio/ByteBuffer:getShort	()S
    //   1170: ldc 46
    //   1172: iand
    //   1173: iastore
    //   1174: ldc 46
    //   1176: aload_0
    //   1177: getfield 55	net/openrs/cache/type/objects/ObjectType:configChangeDest	[I
    //   1180: iload 6
    //   1182: iaload
    //   1183: if_icmpne +11 -> 1194
    //   1186: aload_0
    //   1187: getfield 55	net/openrs/cache/type/objects/ObjectType:configChangeDest	[I
    //   1190: iload 6
    //   1192: iconst_m1
    //   1193: iastore
    //   1194: iinc 6 1
    //   1197: goto -43 -> 1154
    //   1200: aload_0
    //   1201: getfield 55	net/openrs/cache/type/objects/ObjectType:configChangeDest	[I
    //   1204: iload_3
    //   1205: iconst_1
    //   1206: iadd
    //   1207: iload 5
    //   1209: iastore
    //   1210: return
    //   1211: return
    // Line number table:
    //   Java source line #78	-> byte code offset #0
    //   Java source line #81	-> byte code offset #13
    //   Java source line #82	-> byte code offset #18
    //   Java source line #83	-> byte code offset #27
    //   Java source line #84	-> byte code offset #34
    //   Java source line #85	-> byte code offset #41
    //   Java source line #86	-> byte code offset #48
    //   Java source line #88	-> byte code offset #51
    //   Java source line #89	-> byte code offset #60
    //   Java source line #90	-> byte code offset #74
    //   Java source line #91	-> byte code offset #89
    //   Java source line #92	-> byte code offset #92
    //   Java source line #94	-> byte code offset #95
    //   Java source line #95	-> byte code offset #100
    //   Java source line #96	-> byte code offset #108
    //   Java source line #98	-> byte code offset #111
    //   Java source line #99	-> byte code offset #116
    //   Java source line #100	-> byte code offset #125
    //   Java source line #101	-> byte code offset #132
    //   Java source line #102	-> byte code offset #137
    //   Java source line #103	-> byte code offset #144
    //   Java source line #105	-> byte code offset #147
    //   Java source line #106	-> byte code offset #156
    //   Java source line #107	-> byte code offset #170
    //   Java source line #108	-> byte code offset #173
    //   Java source line #110	-> byte code offset #176
    //   Java source line #111	-> byte code offset #182
    //   Java source line #112	-> byte code offset #194
    //   Java source line #114	-> byte code offset #197
    //   Java source line #115	-> byte code offset #203
    //   Java source line #116	-> byte code offset #215
    //   Java source line #118	-> byte code offset #218
    //   Java source line #119	-> byte code offset #224
    //   Java source line #120	-> byte code offset #229
    //   Java source line #122	-> byte code offset #232
    //   Java source line #123	-> byte code offset #238
    //   Java source line #124	-> byte code offset #243
    //   Java source line #126	-> byte code offset #246
    //   Java source line #127	-> byte code offset #252
    //   Java source line #128	-> byte code offset #264
    //   Java source line #130	-> byte code offset #267
    //   Java source line #131	-> byte code offset #273
    //   Java source line #132	-> byte code offset #278
    //   Java source line #134	-> byte code offset #281
    //   Java source line #135	-> byte code offset #287
    //   Java source line #136	-> byte code offset #292
    //   Java source line #138	-> byte code offset #295
    //   Java source line #139	-> byte code offset #301
    //   Java source line #140	-> byte code offset #306
    //   Java source line #142	-> byte code offset #309
    //   Java source line #143	-> byte code offset #315
    //   Java source line #144	-> byte code offset #326
    //   Java source line #145	-> byte code offset #338
    //   Java source line #146	-> byte code offset #343
    //   Java source line #148	-> byte code offset #346
    //   Java source line #149	-> byte code offset #352
    //   Java source line #150	-> byte code offset #357
    //   Java source line #152	-> byte code offset #360
    //   Java source line #153	-> byte code offset #366
    //   Java source line #154	-> byte code offset #378
    //   Java source line #156	-> byte code offset #381
    //   Java source line #157	-> byte code offset #387
    //   Java source line #158	-> byte code offset #395
    //   Java source line #160	-> byte code offset #398
    //   Java source line #161	-> byte code offset #404
    //   Java source line #162	-> byte code offset #412
    //   Java source line #164	-> byte code offset #415
    //   Java source line #165	-> byte code offset #427
    //   Java source line #166	-> byte code offset #440
    //   Java source line #167	-> byte code offset #460
    //   Java source line #168	-> byte code offset #470
    //   Java source line #170	-> byte code offset #473
    //   Java source line #171	-> byte code offset #479
    //   Java source line #172	-> byte code offset #488
    //   Java source line #173	-> byte code offset #495
    //   Java source line #174	-> byte code offset #502
    //   Java source line #176	-> byte code offset #505
    //   Java source line #177	-> byte code offset #514
    //   Java source line #178	-> byte code offset #529
    //   Java source line #179	-> byte code offset #544
    //   Java source line #180	-> byte code offset #547
    //   Java source line #182	-> byte code offset #550
    //   Java source line #183	-> byte code offset #556
    //   Java source line #184	-> byte code offset #565
    //   Java source line #185	-> byte code offset #572
    //   Java source line #186	-> byte code offset #579
    //   Java source line #188	-> byte code offset #582
    //   Java source line #189	-> byte code offset #591
    //   Java source line #190	-> byte code offset #606
    //   Java source line #191	-> byte code offset #621
    //   Java source line #192	-> byte code offset #624
    //   Java source line #194	-> byte code offset #627
    //   Java source line #195	-> byte code offset #633
    //   Java source line #196	-> byte code offset #644
    //   Java source line #198	-> byte code offset #647
    //   Java source line #199	-> byte code offset #653
    //   Java source line #200	-> byte code offset #658
    //   Java source line #202	-> byte code offset #661
    //   Java source line #203	-> byte code offset #667
    //   Java source line #204	-> byte code offset #672
    //   Java source line #206	-> byte code offset #675
    //   Java source line #207	-> byte code offset #681
    //   Java source line #208	-> byte code offset #692
    //   Java source line #210	-> byte code offset #695
    //   Java source line #211	-> byte code offset #701
    //   Java source line #212	-> byte code offset #712
    //   Java source line #214	-> byte code offset #715
    //   Java source line #215	-> byte code offset #721
    //   Java source line #216	-> byte code offset #732
    //   Java source line #218	-> byte code offset #735
    //   Java source line #219	-> byte code offset #741
    //   Java source line #220	-> byte code offset #752
    //   Java source line #222	-> byte code offset #755
    //   Java source line #223	-> byte code offset #761
    //   Java source line #224	-> byte code offset #773
    //   Java source line #226	-> byte code offset #776
    //   Java source line #227	-> byte code offset #782
    //   Java source line #228	-> byte code offset #793
    //   Java source line #230	-> byte code offset #796
    //   Java source line #231	-> byte code offset #802
    //   Java source line #232	-> byte code offset #813
    //   Java source line #234	-> byte code offset #816
    //   Java source line #235	-> byte code offset #822
    //   Java source line #236	-> byte code offset #833
    //   Java source line #238	-> byte code offset #836
    //   Java source line #239	-> byte code offset #842
    //   Java source line #240	-> byte code offset #847
    //   Java source line #242	-> byte code offset #850
    //   Java source line #243	-> byte code offset #856
    //   Java source line #244	-> byte code offset #861
    //   Java source line #246	-> byte code offset #864
    //   Java source line #247	-> byte code offset #870
    //   Java source line #248	-> byte code offset #882
    //   Java source line #249	-> byte code offset #885
    //   Java source line #250	-> byte code offset #897
    //   Java source line #251	-> byte code offset #903
    //   Java source line #252	-> byte code offset #914
    //   Java source line #253	-> byte code offset #929
    //   Java source line #254	-> byte code offset #935
    //   Java source line #255	-> byte code offset #946
    //   Java source line #256	-> byte code offset #957
    //   Java source line #257	-> byte code offset #969
    //   Java source line #258	-> byte code offset #978
    //   Java source line #259	-> byte code offset #985
    //   Java source line #261	-> byte code offset #988
    //   Java source line #262	-> byte code offset #997
    //   Java source line #263	-> byte code offset #1011
    //   Java source line #264	-> byte code offset #1014
    //   Java source line #265	-> byte code offset #1017
    //   Java source line #266	-> byte code offset #1023
    //   Java source line #267	-> byte code offset #1031
    //   Java source line #268	-> byte code offset #1037
    //   Java source line #269	-> byte code offset #1048
    //   Java source line #274	-> byte code offset #1058
    //   Java source line #275	-> byte code offset #1069
    //   Java source line #276	-> byte code offset #1078
    //   Java source line #278	-> byte code offset #1083
    //   Java source line #279	-> byte code offset #1094
    //   Java source line #280	-> byte code offset #1103
    //   Java source line #283	-> byte code offset #1108
    //   Java source line #284	-> byte code offset #1111
    //   Java source line #285	-> byte code offset #1117
    //   Java source line #286	-> byte code offset #1123
    //   Java source line #287	-> byte code offset #1130
    //   Java source line #291	-> byte code offset #1133
    //   Java source line #293	-> byte code offset #1142
    //   Java source line #295	-> byte code offset #1151
    //   Java source line #296	-> byte code offset #1160
    //   Java source line #297	-> byte code offset #1174
    //   Java source line #298	-> byte code offset #1186
    //   Java source line #295	-> byte code offset #1194
    //   Java source line #302	-> byte code offset #1200
    //   Java source line #305	-> byte code offset #1210
    //   Java source line #307	-> byte code offset #1211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1212	0	this	ObjectType
    //   0	1212	1	buffer	ByteBuffer
    //   9	1103	2	opcode	int
    //   26	28	3	length	int
    //   124	26	3	length	int
    //   487	21	3	length	int
    //   564	21	3	length	int
    //   977	14	3	length	int
    //   1141	64	3	length	int
    //   49	41	4	index	int
    //   145	26	4	index	int
    //   503	42	4	index	int
    //   580	42	4	index	int
    //   986	26	4	index	int
    //   1109	99	5	var3	int
    //   1152	43	6	var5	int
  }
  
  public ByteBuffer encode()
  {
    ByteBuffer buffer = ByteBuffer.allocate(1132);
    return (ByteBuffer)buffer.flip();
  }
  
  public int getID()
  {
    return id;
  }
  
  public short[] getRetextureToFind() {
    return retextureToFind;
  }
  
  public void setRetextureToFind(short[] retextureToFind) {
    this.retextureToFind = retextureToFind;
  }
  
  public int getAnInt2069() {
    return anInt2069;
  }
  
  public void setAnInt2069(int anInt2069) {
    this.anInt2069 = anInt2069;
  }
  
  public boolean isSolid() {
    return isSolid;
  }
  
  public void setSolid(boolean isSolid) {
    this.isSolid = isSolid;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public int[] getObjectModels() {
    return objectModels;
  }
  
  public void setObjectModels(int[] objectModels) {
    this.objectModels = objectModels;
  }
  
  public int[] getObjectTypes() {
    return objectTypes;
  }
  
  public void setObjectTypes(int[] objectTypes) {
    this.objectTypes = objectTypes;
  }
  
  public short[] getRecolorToFind() {
    return recolorToFind;
  }
  
  public void setRecolorToFind(short[] recolorToFind) {
    this.recolorToFind = recolorToFind;
  }
  
  public int getMapIconID() {
    return mapIconID;
  }
  
  public void setMapIconID(int mapIconID) {
    this.mapIconID = mapIconID;
  }
  
  public short[] getTextureToReplace() {
    return textureToReplace;
  }
  
  public void setTextureToReplace(short[] textureToReplace) {
    this.textureToReplace = textureToReplace;
  }
  
  public int getSizeX() {
    return sizeX;
  }
  
  public void setSizeX(int sizeX) {
    this.sizeX = sizeX;
  }
  
  public int getSizeY() {
    return sizeY;
  }
  
  public void setSizeY(int sizeY) {
    this.sizeY = sizeY;
  }
  
  public int getAnInt2083() {
    return anInt2083;
  }
  
  public void setAnInt2083(int anInt2083) {
    this.anInt2083 = anInt2083;
  }
  
  public int[] getAnIntArray2084() {
    return anIntArray2084;
  }
  
  public void setAnIntArray2084(int[] anIntArray2084) {
    this.anIntArray2084 = anIntArray2084;
  }
  
  public int getOffsetX() {
    return offsetX;
  }
  
  public void setOffsetX(int offsetX) {
    this.offsetX = offsetX;
  }
  
  public boolean isNonFlatShading() {
    return nonFlatShading;
  }
  
  public void setNonFlatShading(boolean nonFlatShading) {
    this.nonFlatShading = nonFlatShading;
  }
  
  public int getAnInt2088() {
    return anInt2088;
  }
  
  public void setAnInt2088(int anInt2088) {
    this.anInt2088 = anInt2088;
  }
  
  public int getAnimationID() {
    return animationID;
  }
  
  public void setAnimationID(int animationID) {
    this.animationID = animationID;
  }
  
  public int getVarpID() {
    return varpID;
  }
  
  public void setVarpID(int varpID) {
    this.varpID = varpID;
  }
  
  public int getAmbient() {
    return ambient;
  }
  
  public void setAmbient(int ambient) {
    this.ambient = ambient;
  }
  
  public int getContrast() {
    return contrast;
  }
  
  public void setContrast(int contrast) {
    this.contrast = contrast;
  }
  
  public String[] getActions() {
    return actions;
  }
  
  public void setActions(String[] actions) {
    this.actions = actions;
  }
  
  public int getAnInt2094() {
    return anInt2094;
  }
  
  public void setAnInt2094(int anInt2094) {
    this.anInt2094 = anInt2094;
  }
  
  public int getMapSceneID() {
    return mapSceneID;
  }
  
  public void setMapSceneID(int mapSceneID) {
    this.mapSceneID = mapSceneID;
  }
  
  public short[] getRecolorToReplace() {
    return recolorToReplace;
  }
  
  public void setRecolorToReplace(short[] recolorToReplace) {
    this.recolorToReplace = recolorToReplace;
  }
  
  public boolean isaBool2097() {
    return aBool2097;
  }
  
  public void setaBool2097(boolean aBool2097) {
    this.aBool2097 = aBool2097;
  }
  
  public int getModelSizeX() {
    return modelSizeX;
  }
  
  public void setModelSizeX(int modelSizeX) {
    this.modelSizeX = modelSizeX;
  }
  
  public int getModelSizeHeight() {
    return modelSizeHeight;
  }
  
  public void setModelSizeHeight(int modelSizeHeight) {
    this.modelSizeHeight = modelSizeHeight;
  }
  
  public int getModelSizeY() {
    return modelSizeY;
  }
  
  public void setModelSizeY(int modelSizeY) {
    this.modelSizeY = modelSizeY;
  }
  
  public int getObjectID() {
    return objectID;
  }
  
  public void setObjectID(int objectID) {
    this.objectID = objectID;
  }
  
  public int getOffsetHeight() {
    return offsetHeight;
  }
  
  public void setOffsetHeight(int offsetHeight) {
    this.offsetHeight = offsetHeight;
  }
  
  public int getOffsetY() {
    return offsetY;
  }
  
  public void setOffsetY(int offsetY) {
    this.offsetY = offsetY;
  }
  
  public boolean isaBool2104() {
    return aBool2104;
  }
  
  public void setaBool2104(boolean aBool2104) {
    this.aBool2104 = aBool2104;
  }
  
  public int getAnInt2105() {
    return anInt2105;
  }
  
  public void setAnInt2105(int anInt2105) {
    this.anInt2105 = anInt2105;
  }
  
  public int getAnInt2106() {
    return anInt2106;
  }
  
  public void setAnInt2106(int anInt2106) {
    this.anInt2106 = anInt2106;
  }
  
  public int[] getConfigChangeDest() {
    return configChangeDest;
  }
  
  public void setConfigChangeDest(int[] configChangeDest) {
    this.configChangeDest = configChangeDest;
  }
  
  public boolean isaBool2108() {
    return aBool2108;
  }
  
  public void setaBool2108(boolean aBool2108) {
    this.aBool2108 = aBool2108;
  }
  
  public int getConfigId() {
    return configId;
  }
  
  public void setConfigId(int configId) {
    this.configId = configId;
  }
  
  public int getAnInt2110() {
    return anInt2110;
  }
  
  public void setAnInt2110(int anInt2110) {
    this.anInt2110 = anInt2110;
  }
  
  public boolean isaBool2111() {
    return aBool2111;
  }
  
  public void setaBool2111(boolean aBool2111) {
    this.aBool2111 = aBool2111;
  }
  
  public int getAnInt2112() {
    return anInt2112;
  }
  
  public void setAnInt2112(int anInt2112) {
    this.anInt2112 = anInt2112;
  }
  
  public int getAnInt2113() {
    return anInt2113;
  }
  
  public void setAnInt2113(int anInt2113) {
    this.anInt2113 = anInt2113;
  }
  
  public boolean isaBool2114() {
    return aBool2114;
  }
  
  public void setaBool2114(boolean aBool2114) {
    this.aBool2114 = aBool2114;
  }
  
  @Override
	public ByteBuffer encode317() {
		ByteBuffer buffer = ByteBuffer.allocate(1132);
		return (ByteBuffer) buffer.flip();
	}
}
