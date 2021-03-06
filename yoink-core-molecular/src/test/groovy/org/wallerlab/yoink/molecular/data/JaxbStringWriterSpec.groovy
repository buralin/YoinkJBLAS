package org.wallerlab.yoink.molecular.data

import javax.xml.bind.JAXBElement

import org.apache.commons.io.FileUtils

import org.xml_cml.schema.Cml

import spock.lang.Specification

class JaxbStringWriterSpec extends Specification {

	def"write()"(){
		when:"jaxb writer writes  an object from jaxb reader"
			def reader= new JaxbStringReader()
			def input = """<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<cml xmlns="http://www.xml-cml.org/schema">
    <moleculeList>
        <molecule id="QM_CORE_FIXED">
            <atomArray>
                <atom id="a1" x3="-0.194175" z3="0.0" y3="1.280807" elementType="Li"/>
            </atomArray>
        </molecule>
        <molecule id="QM_CORE_FIXED">
            <atomArray>
                <atom id="a2" x3="-1.724175" z3="0.0" y3="1.280807" elementType="H"/>
            </atomArray>
        </molecule>
    </moleculeList>
    <parameterList title="parameters">
        <parameter name="NUMBER_QM" value="8"/>
        <parameter name="NUMBER_BUFFER" value="5"/>
        <parameter name="DISTANCE_QM" value="5"/>
        <parameter name="DENSITY_ASR_QM" value="0.000001"/>
        <parameter name="DENSITY_DORI" value="0.0001"/>
        <parameter name="DENSITY_SEDD" value="0.1"/>
        <parameter name="SEDD" value="2"/>
        <parameter name="DORI" value="0.9"/>
        <parameter name="DENSITY_RATIO_MIN" value="0.064"/>
        <parameter name="DENSITY_RATIO_MAX" value="15.67"/>
        <parameter name="DENSITY_ASR_QMCORE" value="0.0001"/>
        <parameter name="DISTANCE_BUFFER" value="0.9"/>
        <parameter name="DENSITY_BUFFER" value="0.0000001"/>
        <parameter name="DENSITY_QM" value="0.001"/>
        <parameter name="REGION_CUBE" value="ADAPTIVE_SEARCH"/>
        <parameter name="SEDD_STEPSIZE" value="0.9 0.9 0.9"/>
        <parameter name="DORI_STEPSIZE" value="0.5 0.5 0.5"/>
        <parameter name="PARTITIONER" value="NUMBER"/>
        <parameter name="SMOOTHNER" value="DISTANCE_BUFFERED_FORCE"/>
        <parameter name="JOB_NAME" value="NUMBER_BUFFERED_FORCE"/>
        <parameter name="INPUT_FOLDER" value="./inputs"/>
        <parameter name="OUTPUT_FOLDER" value="./outputs"/>
    </parameterList>
</cml>"""
			def msr=(JAXBElement<Cml>)reader.read(input, new Cml())
			def writer= new JaxbStringWriter()
			
			writer.write("not-used", msr.getValue())
		then:"the out file and the input file are the same"
			 writer.getOutput() 		
	}
}
