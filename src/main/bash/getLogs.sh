#!/bin/bash
cd ../tmp
pathFile=$PWD;
cd "$1";
git log >> logs.txt;
git remote show origin >> gitInfo.txt
mv logs.txt "$pathFile";
mv gitInfo.txt "$pathFile";
