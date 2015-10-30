package com.anikora;

import java.io.IOException;


public class ContentFilter {
	static String badwords="ahole anus ash0le ash0les asholes ass Ass Assface assh0le assh0lez asshole assholes assholz asswipe azzhole bassterds bastard bastards bastardz basterds basterdz Biatch bitch bitches BlowJob boffing butthole buttwipe c0ck c0cks c0k Muncher cawk cawks Clit cnts cntz cock cockhead cock-head cocks CockSucker cock-sucker crap cum cunt cunts cuntz dick dild0 dild0s dildo dildos dilld0 dilld0s dominatricks dominatrics dominatrix dyke enema fuck fuker fag fag1t faget fagg1t faggit faggot fagit fags fagz faig faigs fart fuck fucker fuckin fucking fucks Fudge fuk Fukah Fuken fuker Fukin Fukk Fukkah Fukken Fukker Fukkin g00k gay gayboy gaygirl gays gayz God-damned h00r h0ar h0re hoar hoor hoore jackoff jap japs jerk-off jisim jiss jizm jizz knobs knobz kunt kunts kuntz Lesbian Lezzian Lipshits Lipshitz masochist masokist massterbait masstrbait masstrbate masterbaiter masterbate masterbates Motha Fucker Motha Fuker Motha Fukkah Motha Fukker Fucker Fukah Fuker Fukkah Fukker mother-fucker Mutha Fucker Mutha Fukah Mutha Fuker Mutha Fukkah Mutha Fukker n1gr nastt nigger; nigur; niiger; niigr; orafis orgasim; orgasm orgasum oriface orifice orifiss packi packie packy paki pakie paky pecker peeenus peeenusss peenus peinus pen1s penas penis penis-breath penus penuus Phuc Phuck Phuk Phuker Phukker polac polack Poonani pr1c pr1ck pr1k pusse pussee pussy puuke puuker queer queers queerz qweers qweerz qweir recktum rectum retard sadist scank schlong screwing semen sex sexy Sh!t sh1t sh1ter sh1ts sh1tter sh1tz shit shits shitter Shitty Shity shitz Shyt Shyte Shytty Shyty skanck skank skankee skankey skanks Skanky slut sluts Slutty slutz son-of-a-bitch tit turd va1jina vag1na vagiina vagina vaj1na vajina vullva vulva w0p wh00r wh0re whore xrated xxx b!+ch bitch blowjob clit arschloch fuck shit ass asshole b!tch b17ch b1tch bastard bi+ch boiolas buceta c0ck cawk chink cipa clits cock cum cunt dildo dirsa ejakulate fatass fcuk fuk fux0r hoer hore jism kawk l3itch l3i+ch lesbian masturbate masterbat* masterbat3 motherfucker s.o.b. mofo nazi nigga nigger nutsack phuck pimpis pusse pussy scrotum sh!t shemale shi+ sh!+ slut smut teets tits boobs b00bs teez testical testicle titt w00se jackoff wank whoar whore *damn *dyke *fuck* *shit* @$$ amcik andskota arse* assrammer ayir bi7ch bitch* bollock* breasts butt-pirate cabron cazzo chraa chuj Cock* cunt* d4mn daygo dego dick* dike* dupa dziwka ejackulate Ekrem* Ekto enculer faen fag* fanculo fanny feces feg Felcher ficken fitt* Flikker foreskin Fotze Fu(* fuk* futkretzn gay gook guiena h0r h4x0r hell helvete hoer* honkey Huevon hui injun jizz kanker* kike klootzak kraut knulle kuk kuksuger Kurac kurwa kusi* kyrpa* lesbo mamhoon masturbat* merd* mibun monkleigh mouliewop muie mulkku muschi nazis nepesaurio nigger* orospu paska* perse picka pierdol* pillu* pimmel piss* pizda poontsee poop porn p0rn pr0n preteen pula pule puta puto qahbeh queef* rautenberg schaffer scheiss* schlampe schmuck screw sh!t* sharmuta sharmute shipal shiz skribz skurwysyn sphencter spic spierdalaj splooge suka b00b* testicle* titt* twat vittu wank* wetback* wichser wop* yed zabourah";

	public static void main(String s[]) throws IOException
	{ String info = "what is asshole";
	   System.out.println(replaceMiddle(info));

	}

	public static boolean checker(String check)
	{
		boolean result=false;
		check.replaceAll("[\\W]|_", " ");
		String[] check_tags=check.split(" ");
		String[] bads = badwords.split(" ");
		for(String  tag : check_tags)
		{
			for(String bad : bads)
			{
			if(bad.equals(tag))
				{ result = true;
				break; 
				}
			}
			if(result == true)
				break;
		}
		return result;

	}
	public static String checkerAndReplacer(String check)
	{
		String result="";
		String[] badwords_tags=badwords.split(" ");
		check.replaceAll("[\\W]|_", " ");
		String[] check_tags=check.split(" ");
		for(String  tag : check_tags)
		{						
			for(String badword:badwords_tags)
			{
				if(tag.contentEquals(badword))
				{  tag="****";				  
					break ;
			     }				
			}
			result=result.concat(" "+tag);
		}		
		return result;
	}
	public static float badContentPercentage(String check)
	{
		float percent=0;
		int count=0;
		check.replaceAll("[\\W]|_", " ");
		String[] check_tags=check.split(" ");
		for(String  tag : check_tags)
		{
			if(badwords.contains(tag))
			{ count++ ;			 
			}
		}
		percent=(count/(float)check_tags.length)*100;
		return percent;
	}
	public static String replaceMiddle(String check)
	{
		String result="";
		String[] badwords_tags=badwords.split(" ");
		check.replaceAll("[\\W]|_", " ");
		String[] check_tags=check.split(" ");
		for(String  tag : check_tags)
		{						
			for(String badword:badwords_tags)
			{
			
				if(tag.contentEquals(badword))
				{  
					System.out.println(tag+"length:"+tag.length());
					tag=tag.charAt(0)+tag.substring(1,tag.length()-1).replaceAll("[a-zA-Z]","*")+tag.charAt(tag.length()-1);				  
					break ;
			     }				
			}
			result=result.concat(" "+tag);
		}		
		return result;
	}

}
