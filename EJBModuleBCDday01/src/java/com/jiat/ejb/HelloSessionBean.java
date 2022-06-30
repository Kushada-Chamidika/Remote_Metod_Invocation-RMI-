/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.jiat.ejb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

/**
 *
 * @author 1999k
 */
// meka stateless kiyala thinawa kiyanne api dnnawa noramli ejb contatiner eke athule ekama ekata adalawa object keepayak hadnawa(Object pool) ekata hethuwa ekk thama muliple hosts karana nisa saha yama awasthawaka kohehari synchronized use karana thinawanam wade ewarawenakn balan inna wena nisa mekedi multiple objects hadan thiyagannawa ethakota me stateless kiyana welawedi apita kiyanna ba ekama object ekama hama welemea ekkenekge request ekata adalawa use wenne kiyala ethkota meken instance wage use karoth varibles api data clash wenna puluwan e nisa stateless welawata instance use karana eka bad practice kiynawa
// stateful kiyana eka use karama ekkenkta adalwa hama welema ekama object eka thama call wenne example widiyata ekekenta adala shopping cart ekakadi wage use karanna puluwan meka dammama objects godak use wena nisa use nowen object thinawanm ewa serialize wela file ekk widiyata store wela thibila aye use wena weleta deserialize wela aye heap ekata load wela thama wada karanne
// singalton use karoth ema hama welema hama kenama eka object eka thama use karanne me dana eka apita one widiyta requirement eka anuwa galapena eka hndata thorala ganna one
//@Stateless
@Stateful
public class HelloSessionBean implements HelloSessionBeanRemote {

    @Override
    public String hello(String name) {
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(HelloSessionBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return "Hello, " + name + this;
    }

    //ejb eken object eka hadena destry wena welawata meka call wenawa
    @PostConstruct
    public void init() {
        System.out.println("Init...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy...");
    }

    // ejb container eke thinawa cache management system ekk ekedi ape object eka use wenawa adu unama eka cahce clear wenna kalin object eke data store karaganan wela wedi thama me prepassivate eka call wenne e wagema post activate eka call wenna ara file ekka wieidyata serialize wela haduna record eka aye deserialize karlaa use karnana gannakota thama call wela apita aye object eka use karala wadak akranna puluwan thatyhweta geanalla denne
    // statfull weladi serialize / deserialize wena wade unada nadda kiyala em method walin apita balaganna puluwan
    @PrePassivate
    public void passivate() {
        System.out.println("Passivate...");
    }

    @PostActivate
    public void activate() {
        System.out.println("Activate...");
    }

}

// api stateful kiyana eka use akraddi eyage wade thama hama welema request eddi aluth objkect ekk hadala dena eka namuth statelss waladi ema wenne na ekama eka use wenna unath puluwan api dnnawa eya ekkin object godak hadan thiyagannawa kiyala 
// statefull awasthawa thama api normaly ekknekta specific object thiyaganna use karanne namuth api nkn statefull kiyala dmma paliyata meya idea ekk na komada ekam user identify karagnne kiyala e nisai ekama user unathkeepa parak request karaddi aluthen object hadenne eka thama staefull ge hati
// ethakota hadena object ekk user kenekta unique karna eka karnana one api thama servlet eka paththen mokada apita e paththe seession cookies url rewritting wage deyak use karala apita puluwan ekama user da me call wenne kiyala dnaganna e ganna data anuwa thama apita sidda wenne statefull welawe ekama object eka alla ganna hadanna
//stateless waladi wage neme statefull waladi api session wage deyak use karala object identify karaganna widiyak haduwama wenne e userta witharak e object eka aithi wena eka ethakota me wage welawadi user hama welema ena kenek neme nm udharanayk widiyata api session cookie walata masa 6k wage expire date ekk dunna kiyala hithauwanm user adin opasse aye enne masa 4kin nm me satefull waladi object eka thiyan inna nisa apita podi galauwak wenawa 
// eda gana prshnayak enawa e wage hama ekama thiyan inna giyama PHP wla wage nm session file ekk wiidyata store karana nisa ema gataluwak na namuth methana object thiyaganna nisa podi prshnyak thinawa ekata apita karanna puluwan deyak thinawa e gataluwa solve karagena nikarune eda use wena eka nawaththganna
// ekedi wenne user kenekta hadapu ekak use wenne aduwen nm eka serialize karalqa file ekk widiyata store karala thiyaganna ethakota aye dawasaka user eddi e serialize karala hadapu file eka deserialize karala userta use karanna puluwan ththweta genawa ethakota nikarune eda yana eka adu wenawa
// statefull welwedi thama meka godakma use wenne mokda ekkenkta ekk witharak hadena nisa
