<?xml version="1.0"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
    <h2>Decathlon participants</h2>
    <table border="1">
      <tr bgcolor="#9acd32">
		<th>Place</th>
        <th>Name</th>
		<th>Total points</th>
        <th>100 m</th>
		<th>Long jump</th>
		<th>Shot put</th>
		<th>High jump</th>
		<th>400 m</th>
		<th>110 m hurdles</th>
		<th>Discus throw</th>
		<th>Pole vault</th>
		<th>Javelin throw</th>
		<th>1500 m</th>
      </tr>
      <xsl:for-each select="competition/participants/entry">
        <tr>
		  <td><xsl:value-of select="place"/></td>  
          <td><xsl:value-of select="name"/></td>          
		  <td><xsl:value-of select="total_points"/></td>          
		  <td><xsl:value-of select="events/_100_m"/></td>          
		  <td><xsl:value-of select="events/Long_jump"/></td>          
		  <td><xsl:value-of select="events/Shot_put"/></td>          
		  <td><xsl:value-of select="events/High_jump"/></td>          
		  <td><xsl:value-of select="events/_400_m"/></td>
		  <td><xsl:value-of select="events/_110_m_hurdles"/></td>          
		  <td><xsl:value-of select="events/Discus_throw"/></td>          
		  <td><xsl:value-of select="events/Pole_vault"/></td>          
		  <td><xsl:value-of select="events/Javelin_throw"/></td>          
		  <td><xsl:value-of select="events/_1500_m"/></td>          
        </tr>
      </xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>