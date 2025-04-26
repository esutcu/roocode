import { json } from '@sveltejs/kit';

export function GET() {
  // Mock bookings data
  const bookings = [
    {
      id: '1',
      date: '2025-05-01',
      time: '14:00 - 17:00',
      teacher: 'Jane Smith',
      status: 'Scheduled'
    },
    {
      id: '2',
      date: '2025-05-03',
      time: '14:00 - 17:00',
      teacher: 'Jane Smith',
      status: 'Scheduled'
    },
    {
      id: '3',
      date: '2025-05-05',
      time: '14:00 - 17:00',
      teacher: 'Jane Smith',
      status: 'Scheduled'
    }
  ];

  return json(bookings);
}