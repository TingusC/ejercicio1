<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="html" encoding="UTF-8" indent="yes"/>

    <xsl:template match="/Jugadores">
        <html>
            <head>
                <meta charset="UTF-8"/>
                <title>Listado de Jugadores</title>
            </head>
            <body>
                <h1>Listado de Jugadores</h1>

                <table border="1">
                    <tr>
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>Equipo</th>
                        <th>PXP</th>
                        <th>Activo</th>
                    </tr>

                    <xsl:for-each select="Jugador">
                        <tr>
                            <td><xsl:value-of select="codigo"/></td>
                            <td><xsl:value-of select="nombre"/></td>
                            <td><xsl:value-of select="equipo"/></td>
                            <td><xsl:value-of select="PXP"/></td>
                            <td><xsl:value-of select="activo"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>