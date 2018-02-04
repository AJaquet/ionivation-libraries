package com.ionivation.libs.system;

import java.security.CodeSource;

/**
 * GetAppPath
 * Diese Klasse versucht zu erkennen ob das Programm aus einem Paket herraus 
 * gestartet wurde.
 * 
 * FIXME: unter unix kann die jar-Datei keine Endung haben und dennoch ein Container sein
 * 
 * @author Adam Jaquet - 2018
 * @version 0.1
 */
public class GetAppPath
{
    /** wenn true, wurde die Applikation aus einem Archiv gestartet */
    public final boolean isJar;
    private final String [] preFixe = {".jar", ".JAR", ".exe", ".EXE", ".sh", ".SH"};
    private final CodeSource source = getClass().getProtectionDomain().getCodeSource();
    
    /**
     * true wenn es sich bei der Ausführenden Datei um eine in <code>preFixe</code>
     * definierte Dateiendung handelt.
     */
    public GetAppPath()
    {
        /**
         * Im Konstruktor bestlegen ob es sich bei der Programmdatei um einen
         * Container handelt.
         */       
        this.isJar = isJar();    
    }
    
    /**
     * @return String - gibt den Pfad dieser Jar-Datei zurück 
     */
    public String getCurrentJarPath( )
    {
        String path = getJarPath( );
        
        if (path == null) { path = source.toString(); }
        
        String returnBuffer = path;
        
        for (String buffer : preFixe)
        {
            if( path.endsWith( buffer ) )    
            {
                returnBuffer = path.substring( 0, path.lastIndexOf("/") );
                break;
            }
        }
        return returnBuffer;
    }
 
    /**
     * @return String - gibt den absoluten Pfad inklusive Dateiname dieser Anwendung zurück
     */
    public String getJarPath( )
    {
        CodeSource _buffer = source;
        
        if (_buffer != null) {
            return _buffer.getLocation().getPath().replaceAll("%20", " ");
        }
        return null;
    }
    
    /**
     * Gibt true zurueck falls es sich bei der Startdatei um eine 
     * .jar .exe .sh handelt.
     * 
     * TODO: Dateiendung unanhaengig waere wünschenwert
     * 
     * @return boolean true wennn Startdatei .jar .exe oder .sh
     */
    private boolean isJar()
    {
        String path = getJarPath( );
        boolean _rb = false;
        
        // TODO: kann man das auch abkuerzen?
        for (String _buffer : preFixe)
        {
            if( path.endsWith( _buffer ) )    
            {
                _rb = true;
            } 
        }
        return _rb;
    }
    
    @Override
    public String toString()
    {
        return ( "\n"
                + "getJarPath: " + this.getJarPath() 
                + "\ngetCurrentJarPath: " + this.getCurrentJarPath()
                + "\nisJar: " + this.isJar );
    }
}
