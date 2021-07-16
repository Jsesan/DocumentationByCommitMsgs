#!/bin/bash
cd .. ;
echo "$PWD"
rm -r ./tmp ;
mkdir "tmp" ;
cd .. ;
cd .. ;
mv ./documentation.txt "$1";
