import { json } from '@sveltejs/kit';

export function GET() {
  // Mock credit packages data
  const packages = [
    {
      id: '1',
      name: 'Basic Package',
      credits: 10,
      price: 49.99
    },
    {
      id: '2',
      name: 'Standard Package',
      credits: 20,
      price: 89.99
    },
    {
      id: '3',
      name: 'Premium Package',
      credits: 50,
      price: 199.99
    }
  ];

  return json(packages);
}