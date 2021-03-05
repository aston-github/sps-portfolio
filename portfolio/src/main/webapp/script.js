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
function addRandomFact() {
    const facts = ["I love museums", "I'm trilingual", 'I have a spot of gray hair', 'I am a triathlete',
        "I hate zucchini", "I can barely whistle", "I love avocados"
    ];

    // Pick a random greeting.
    const fact = facts[Math.floor(Math.random() * facts.length)];

    // Add it to the page.
    const factContainer = document.getElementById('fact-container');
    factContainer.innerText = fact;
}

/** Fetches the current date from the server and adds it to the page. */
async function showFav() {
  const responseFromServer = await fetch('/hello');
  const favs = await responseFromServer.json();
//   const textFromResponse = await responseFromServer.text();
  const favElement = document.getElementById('fav-container');
  favElement.innerHTML = '';
  const i = Math.floor(Math.random() * 9);
  favElement.appendChild(
      createParElement(favs[i]));  

}

/** Creates an <li> element containing text. */
function createParElement(text) {
  const pElement = document.createElement('p');
  pElement.innerText = text;
  return pElement;
}

