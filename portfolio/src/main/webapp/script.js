// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {
  const greetings =
      ['Hello world!', '¡Hola Mundo!', '你好，世界！', 'Bonjour le monde!'];

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;
}

/**
 * Fetches hard coded list of strings and randomly chooses to display one
 */
async function displayName() {
    const responseFromServer = await fetch('/hello');
    const allData = await responseFromServer.json(); 
    var halfLen = (Object.keys(allData).length / 2);
    var index = Math.floor(Math.random() * (halfLen));
    const nameContainer = document.getElementById('name-greeting-text');
    nameContainer.innerText = allData[index];
    const img = document.getElementById('greeting-image');
    img.src = allData[index + halfLen];
 }
 
