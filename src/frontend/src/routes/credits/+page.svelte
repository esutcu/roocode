<script lang="ts">
  import { page } from '$app/stores';
  import { onMount } from 'svelte';
  import { goto } from '$app/navigation';
  import { browser } from '$app/environment';
  
  let userRole = 'student'; // Default role
  let credits = 0;
  
  if (browser) {
    onMount(async () => {
      // Get user role from localStorage
      const storedRole = localStorage.getItem('userRole');
      if (storedRole) {
        userRole = storedRole;
      }
      
      // Fetch user credits
      const creditsResponse = await fetch('/api/user/credits');
      if (creditsResponse.ok) {
        const creditsData = await creditsResponse.json();
        credits = creditsData.credits;
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
          <h1 class="text-lg leading-6 font-medium text-gray-900">Credits Management</h1>
          <p class="mt-1 max-w-2xl text-sm text-gray-500">View and manage your credits</p>
        </div>
        <div class="border-t border-gray-200">
          <div class="px-4 py-5 sm:p-6">
            <div class="bg-blue-50 overflow-hidden shadow rounded-lg">
              <div class="px-4 py-5 sm:p-6">
                <div class="flex items-center">
                  <div class="flex-shrink-0 bg-blue-100 rounded-md p-3">
                    <svg class="h-6 w-6 text-blue-600" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                      <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 6v6m0-6h6m-6 0H6" />
                    </svg>
                  </div>
                  <div class="ml-5 w-0">
                    <dl>
                      <dt class="text-sm font-medium text-gray-500 truncate">Your Credits</dt>
                      <dd class="text-3xl font-semibold text-gray-900">{credits}</dd>
                    </dl>
                  </div>
                </div>
              </div>
              <div class="bg-blue-50 px-4 py-4 sm:px-6">
                <div class="flex items-center justify-between">
                  <div class="text-sm font-medium text-blue-600">
                    <a href="/credits/buy">Buy Credits</a>
                  </div>
                  <div class="text-sm font-medium text-blue-600">
                    <a href="/credits/history">View History</a>
                  </div>
                </div>
              </div>
            </div>
            
            <div class="mt-8">
              <h2 class="text-lg font-medium text-gray-900">Credit Transactions</h2>
              <div class="mt-4 overflow-hidden shadow ring-1 ring-black ring-opacity-5 rounded-lg sm:rounded-xl">
                <table class="min-w-full divide-y divide-gray-300">
                  <thead class="bg-gray-50">
                    <tr>
                      <th scope="col" class="py-3.5 pl-4 pr-3 text-left text-sm font-semibold text-gray-900 sm:pl-6">Date</th>
                      <th scope="col" class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">Type</th>
                      <th scope="col" class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">Amount</th>
                      <th scope="col" class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">Status</th>
                    </tr>
                  </thead>
                  <tbody class="divide-y divide-gray-200 bg-white">
                    <tr>
                      <td class="whitespace-nowrap py-4 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-6">2025-04-20</td>
                      <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500">Purchase</td>
                      <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500">+100</td>
                      <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500">
                        <span class="inline-flex items-center rounded-full bg-green-100 px-2.5 py-0.5 text-xs font-medium text-green-800">
                          Completed
                        </span>
                      </td>
                    </tr>
                    <tr>
                      <td class="whitespace-nowrap py-4 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-6">2025-04-15</td>
                      <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500">Session</td>
                      <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500">-1</td>
                      <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500">
                        <span class="inline-flex items-center rounded-full bg-green-100 px-2.5 py-0.5 text-xs font-medium text-green-800">
                          Completed
                        </span>
                      </td>
                    </tr>
                    <tr>
                      <td class="whitespace-nowrap py-4 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-6">2025-04-10</td>
                      <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500">Purchase</td>
                      <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500">+50</td>
                      <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500">
                        <span class="inline-flex items-center rounded-full bg-green-100 px-2.5 py-0.5 text-xs font-medium text-green-800">
                          Completed
                        </span>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </main>
</div>