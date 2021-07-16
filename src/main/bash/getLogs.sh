#!/bin/bash
cd ../tmp
pathFile=$PWD;
cd "$1";
git log >> logs.txt;
cat logs.txt;
mv logs.txt "$pathFile";
