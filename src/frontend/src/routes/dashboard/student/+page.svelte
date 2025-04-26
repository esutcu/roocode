<script lang="ts">
  import { page } from '$app/stores';
  import { onMount } from 'svelte';
  import { goto } from '$app/navigation';
  import { browser } from '$app/environment';
  
  let userRole = 'student'; // Default role
  let user: {
    id: string;
    email: string;
    firstName: string;
    lastName: string;
    credits: number;
  } = {
    id: '',
    email: '',
    firstName: '',
    lastName: '',
    credits: 0
  };
  
  let bookings: Array<{
    id: string;
    date: string;
    time: string;
    teacher: string;
    status: string;
  }> = [];
  
  let creditPackages: Array<{
    id: string;
    name: string;
    credits: number;
    price: number;
  }> = [];
  
  if (browser) {
    onMount(async () => {
      // Get user role from localStorage
      const storedRole = localStorage.getItem('userRole');
      if (storedRole) {
        userRole = storedRole;
      }
      
      // Fetch user data
      const userResponse = await fetch('/api/user/profile');
      if (userResponse.ok) {
        user = await userResponse.json();
      }
      
      // Fetch user bookings
      const bookingsResponse = await fetch('/api/user/bookings');
      if (bookingsResponse.ok) {
        bookings = await bookingsResponse.json();
      }
      
      // Fetch credit packages
      const packagesResponse = await fetch('/api/credits/packages');
      if (packagesResponse.ok) {
        creditPackages = await packagesResponse.json();
      }
    });
  }
</script>

<div class="min-h-screen bg-gray-100">
  <nav class="bg-white shadow-md">
    <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
      <div class="flex justify-between h-16">
        <div class="flex">
          <div class="flex-shrink-0 flex items-center">
            <img class="h-8 w-8" src="https://picsum.photos/seed/talkup/32/32.jpg" alt="TalkUp Logo" />
            <span class="ml-2 text-xl font-bold text-blue-600">TalkUp</span>
          </div>
        </div>
        <div class="flex items-center">
          <div class="flex space-x-4">
            <a href="/" class="px-3 py-2 rounded-md text-sm font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50">Home</a>
            <a href="/dashboard" class="px-3 py-2 rounded-md text-sm font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50">Dashboard</a>
            <a href="/credits" class="px-3 py-2 rounded-md text-sm font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50">Credits</a>
            <a href="/bookings" class="px-3 py-2 rounded-md text-sm font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50">Bookings</a>
            <a href="/settings" class="px-3 py-2 rounded-md text-sm font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50">Settings</a>
          </div>
        </div>
      </div>
    </div>
  </nav>
  
  <main class="max-w-7xl mx-auto py-6 sm:px-6 lg:px-8">
    <div class="px-4 py-6 sm:px-0">
      <div class="bg-white shadow overflow-hidden sm:rounded-lg">
        <div class="px-4 py-5 sm:px-6">
          <h1 class="text-lg leading-6 font-medium text-gray-900">Student Dashboard</h1>
          <p class="mt-1 max-w-2xl text-sm text-gray-500">Manage your lessons and credits</p>
        </div>
        <div class="border-t border-gray-200">
          <div class="px-4 py-5 sm:p-6">
            <div class="grid grid-cols-1 gap-6 lg:grid-cols-2">
              <!-- Left Column: User Info and Credits -->
              <div class="space-y-6">
                <!-- User Info Card -->
                <div class="bg-white overflow-hidden shadow rounded-lg">
                  <div class="px-4 py-5 sm:p-6">
                    <div class="flex items-center">
                      <div class="flex-shrink-0 h-12 w-12 rounded-full bg-blue-100 flex items-center justify-center">
                        <svg class="h-8 w-8 text-blue-600" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M16 7a4 4 0 11-8 0 4 4 0 018 0zM12 14a7 7 0 00-7 7"></path>
                        </svg>
                      </div>
                      <div class="ml-4">
                        <h3 class="text-lg leading-6 font-medium text-gray-900">{user.firstName} {user.lastName}</h3>
                        <p class="text-sm text-gray-500">{user.email}</p>
                      </div>
                    </div>
                  </div>
                </div>
                
                <!-- Credits Card -->
                <div class="bg-white overflow-hidden shadow rounded-lg">
                  <div class="px-4 py-5 sm:p-6">
                    <h3 class="text-lg leading-6 font-medium text-gray-900">Your Credits</h3>
                    <div class="mt-2 flex items-center justify-between">
                      <p class="text-3xl font-bold text-blue-600">{user.credits}</p>
                      <button class="inline-flex items-center px-4 py-2 border border-transparent text-sm font-medium rounded-md shadow-sm text-white bg-blue-600 hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500">
                        Purchase Credits
                      </button>
                    </div>
                  </div>
                </div>
                
                <!-- Credit Packages -->
                <div class="bg-white overflow-hidden shadow rounded-lg">
                  <div class="px-4 py-5 sm:p-6">
                    <h3 class="text-lg leading-6 font-medium text-gray-900">Credit Packages</h3>
                    <div class="mt-4 grid grid-cols-1 gap-4 sm:grid-cols-2 lg:grid-cols-3">
                      {#each creditPackages as creditPackage}
                        <div class="border border-gray-200 rounded-lg p-4">
                          <h4 class="text-lg font-medium text-gray-900">{creditPackage.name}</h4>
                          <p class="text-2xl font-bold text-blue-600 mt-2">${creditPackage.price}</p>
                          <p class="text-sm text-gray-500 mt-1">{creditPackage.credits} credits</p>
                          <button class="mt-4 inline-flex items-center px-3 py-2 border border-transparent text-sm leading-4 font-medium rounded-md text-white bg-blue-600 hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500">
                            Purchase
                          </button>
                        </div>
                      {/each}
                    </div>
                  </div>
                </div>
              </div>
              
              <!-- Right Column: Upcoming Lessons -->
              <div class="space-y-6">
                <!-- Upcoming Lessons Card -->
                <div class="bg-white overflow-hidden shadow rounded-lg">
                  <div class="px-4 py-5 sm:p-6">
                    <h3 class="text-lg leading-6 font-medium text-gray-900">Upcoming Lessons</h3>
                    <div class="mt-4">
                      {#if bookings.length > 0}
                        <div class="overflow-hidden shadow ring-1 ring-black ring-opacity-5 sm:rounded-lg">
                          <table class="min-w-full divide-y divide-gray-300">
                            <thead class="bg-gray-50">
                              <tr>
                                <th scope="col" class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">Date</th>
                                <th scope="col" class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">Time</th>
                                <th scope="col" class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">Teacher</th>
                                <th scope="col" class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">Status</th>
                                <th scope="col" class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">Actions</th>
                              </tr>
                            </thead>
                            <tbody class="divide-y divide-gray-200 bg-white">
                              {#each bookings as booking}
                              <tr>
                                <td class="whitespace-nowrap py-4 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-6">{booking.date}</td>
                                <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500">{booking.time}</td>
                                <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500">{booking.teacher}</td>
                                <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500">
                                  <span class="inline-flex items-center rounded-full bg-green-100 px-2.5 py-0.5 text-xs font-medium text-green-800">
                                    {booking.status}
                                  </span>
                                </td>
                                <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500">
                                  <button class="text-blue-600 hover:text-blue-900 mr-2">Join</button>
                                  <button class="text-red-600 hover:text-red-900">Cancel</button>
                                </td>
                              </tr>
                              {/each}
                            </tbody>
                          </table>
                        </div>
                      {:else}
                        <div class="mt-4 text-center">
                          <p class="text-sm text-gray-500">You don't have any upcoming lessons.</p>
                          <p class="text-sm text-gray-500 mt-1">Select your availability to schedule lessons.</p>
                        </div>
                      {/if}
                    </div>
                  </div>
                </div>
                
                <!-- Schedule Availability Card -->
                <div class="bg-white overflow-hidden shadow rounded-lg">
                  <div class="px-4 py-5 sm:p-6">
                    <h3 class="text-lg leading-6 font-medium text-gray-900">Schedule Availability</h3>
                    <p class="mt-1 text-sm text-gray-500">Select 2-7 days per week for your lessons</p>
                    
                    <div class="mt-4">
                      <div class="grid grid-cols-7 gap-2">
                        <div class="text-center">
                          <input type="checkbox" id="monday" name="monday" class="focus:ring-blue-500 h-4 w-4 text-blue-600 border-gray-300 rounded">
                          <label for="monday" class="block text-xs font-medium text-gray-700 mt-1">Mon</label>
                        </div>
                        <div class="text-center">
                          <input type="checkbox" id="tuesday" name="tuesday" class="focus:ring-blue-500 h-4 w-4 text-blue-600 border-gray-300 rounded">
                          <label for="tuesday" class="block text-xs font-medium text-gray-700 mt-1">Tue</label>
                        </div>
                        <div class="text-center">
                          <input type="checkbox" id="wednesday" name="wednesday" class="focus:ring-blue-500 h-4 w-4 text-blue-600 border-gray-300 rounded">
                          <label for="wednesday" class="block text-xs font-medium text-gray-700 mt-1">Wed</label>
                        </div>
                        <div class="text-center">
                          <input type="checkbox" id="thursday" name="thursday" class="focus:ring-blue-500 h-4 w-4 text-blue-600 border-gray-300 rounded">
                          <label for="thursday" class="block text-xs font-medium text-gray-700 mt-1">Thu</label>
                        </div>
                        <div class="text-center">
                          <input type="checkbox" id="friday" name="friday" class="focus:ring-blue-500 h-4 w-4 text-blue-600 border-gray-300 rounded">
                          <label for="friday" class="block text-xs font-medium text-gray-700 mt-1">Fri</label>
                        </div>
                        <div class="text-center">
                          <input type="checkbox" id="saturday" name="saturday" class="focus:ring-blue-500 h-4 w-4 text-blue-600 border-gray-300 rounded">
                          <label for="saturday" class="block text-xs font-medium text-gray-700 mt-1">Sat</label>
                        </div>
                        <div class="text-center">
                          <input type="checkbox" id="sunday" name="sunday" class="focus:ring-blue-500 h-4 w-4 text-blue-600 border-gray-300 rounded">
                          <label for="sunday" class="block text-xs font-medium text-gray-700 mt-1">Sun</label>
                        </div>
                      </div>
                      
                      <div class="mt-4">
                        <label for="time-slot" class="block text-sm font-medium text-gray-700">Time Slot</label>
                        <select id="time-slot" name="time-slot" class="mt-1 block w-full pl-3 pr-10 py-2 text-base border-gray-300 focus:outline-none focus:ring-blue-500 focus:border-blue-500 sm:text-sm rounded-md">
                          <option value="8-11">8:00 AM - 11:00 AM</option>
                          <option value="11-14">11:00 AM - 2:00 PM</option>
                          <option value="14-17">2:00 PM - 5:00 PM</option>
                          <option value="17-20">5:00 PM - 8:00 PM</option>
                          <option value="20-22">8:00 PM - 10:00 PM</option>
                        </select>
                      </div>
                      
                      <div class="mt-4">
                        <button type="button" class="inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-blue-600 hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500">
                          Save Availability
                        </button>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </main>
</div>