#!/bin/bash

# Desired dimensions
COLUMNS=100
ROWS=37

# Resize the front Terminal window
osascript <<EOF
tell application "Terminal"
    activate
    set custom title of front window to "Number Guessing Game – Jenny Spicer 2019/2025"
    set bounds of front window to {100, 100, 1000, 700}
    set number of rows of front window to $ROWS
    set number of columns of front window to $COLUMNS
end tell
EOF

cd "$(dirname "$0")"

### Credits ###
# Check if figlet is installed
if ! command -v figlet &> /dev/null; then
    echo "figlet not found. Installing with Homebrew..."
    # Check if brew is installed
    if ! command -v brew &> /dev/null; then
        echo "Homebrew is not installed. Please install Homebrew first:"
        echo "https://brew.sh/"
        exit 1
    fi
    brew install figlet
    figlet -cf isometric3 -w 100 "JENNY SPICER"
else
    # figlet installed
    figlet -cf isometric3 -w 100 "JENNY SPICER"
fi
                
### Run JAR ###                                                                                                                       
java -jar JennyNumberGuesserGame.jar